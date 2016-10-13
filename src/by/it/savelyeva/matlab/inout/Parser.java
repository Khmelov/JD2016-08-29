package by.it.savelyeva.matlab.inout;

import by.it.savelyeva.matlab.Calc;
import by.it.savelyeva.matlab.vars.Var;
import by.it.savelyeva.matlab.vars.VarFloat;
import by.it.savelyeva.matlab.vars.VarMatrix;
import by.it.savelyeva.matlab.vars.VarVector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Created by nato on 10/11/16.
 */
public class Parser {

    public static final String patternFloat = "^[-]?[0-9]*[.]?[0-9]*$";
    public static final String splitterVector = ",";
    public static final String splitterMatrix = "[\\]}]{1}[,]{1}[{\\[]{1}";
    public static final String patternVariable = "[a-zA-Z]*";
    public static final String unarMinus = "~";

    private static Map<String,Var> storedVariables;
    private static final Map<String,Integer> OPERATIONS = new HashMap<>();
    private static final Set<String> operationSymbols;
    private static final String leftParenthesis = "(";
    private static final String rightParenthesis = ")";

    static {
        OPERATIONS.put("*", 1);
        OPERATIONS.put("/", 1);
        OPERATIONS.put("+", 2);
        OPERATIONS.put("-", 2);
        OPERATIONS.put("=", 3);
        operationSymbols = new HashSet<>(OPERATIONS.keySet());
        operationSymbols.add(leftParenthesis);
        operationSymbols.add(rightParenthesis);
    }

    public static Map<String, Var> getStoredVariables() {
        return storedVariables;
    }

    public static boolean isSupportedOperation(String operation) {
        return OPERATIONS.keySet().contains(operation);
    }

    public static boolean isRegexpMatched(String str, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private static String refactorExpression(String expression) {
        expression = expression.replace(" ", "").replace(",-", ","+unarMinus);
        expression = expression.replace("{-", "{"+unarMinus).replace("[-", "["+unarMinus).replace("(-", "("+unarMinus);
        expression = expression.replace("*-", "*"+unarMinus).replace("/-", "/"+unarMinus).replace("+-", "+"+unarMinus);
        expression = expression.replace("--", "-"+unarMinus).replace("=-", "="+unarMinus);
        if (expression.startsWith("-")) expression = unarMinus + expression.substring(1);
        return expression;
    }

    private static boolean isExpressionValid(String expression, Map<String,Integer> operations) {
        if (expression == null || expression.length() == 0)
            throw new IllegalStateException("Expression is empty");
        if (operations == null || operations.isEmpty())
            throw new IllegalStateException("Operations are not specified");
        return true;
    }

    private static int getNextOperationIndex(String expression, int startIndex) {
        int nextOperationIndex = expression.length();
        for (String operation: operationSymbols) {
            int i = expression.indexOf(operation, startIndex);
            if (i >= 0 && i < nextOperationIndex) {
                nextOperationIndex = i;
            }
        }
        return nextOperationIndex;
    }

    private static String getNextOperation(String expression, int nextOperationIndex) {
        if (nextOperationIndex >= expression.length())
            return "";
        return expression.substring(nextOperationIndex, nextOperationIndex + 1);
    }

    public static String getKeynameOfNullValue(Map<String,Var> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String variableName = it.next();
            if (map.get(variableName) == null) {
                return variableName;
            }
        }
        return "";
    }

    public static String sortingStation(String expression, Map<String,Var> map) {
        assertTrue(isExpressionValid(expression, OPERATIONS));
        expression = refactorExpression(expression);
        storedVariables = map;
        List<String> out = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int index = 0;
        boolean findNext = true;
        while (findNext) {
            int nextOperationIndex = getNextOperationIndex(expression, index);
            String nextOperation = getNextOperation(expression, nextOperationIndex);

            if (nextOperationIndex == expression.length()) {
                findNext = false;
            } else {
                if (index != nextOperationIndex) {
                    String tmp = expression.substring(index, nextOperationIndex);
                    if (isRegexpMatched(tmp, patternVariable)) {
                        if (storedVariables.keySet().contains(tmp)) {
                            tmp = storedVariables.get(tmp).toString();
                        } else storedVariables.put(tmp, null);
                    } //else if (!storedVariables.keySet().contains(tmp)) storedVariables.put(tmp, null);
                    out.add(tmp);
                }
                if (nextOperation.equals(leftParenthesis)) {
                    stack.push(nextOperation);
                } else if (nextOperation.equals(rightParenthesis)) {
                    while (!stack.peek().equals(leftParenthesis)) {
                        out.add(stack.pop());
                        if (stack.empty()) {
                            throw new IllegalStateException("Parenthesis do not match");
                        }
                    }
                    stack.pop();
                } else {
                    while (!stack.empty() && !stack.peek().equals(leftParenthesis) &&
                            (OPERATIONS.get(nextOperation) >= OPERATIONS.get(stack.peek()))) {
                        out.add(stack.pop());
                    }
                    stack.push(nextOperation);
                }
                index = nextOperationIndex + nextOperation.length();
            }
        }

        if (index != expression.length()) {
            out.add(expression.substring(index));
        }
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        if (!out.isEmpty()) {
            result.append(out.remove(0));
        }
        while (!out.isEmpty()) {
            result.append(" ").append(out.remove(0));
        }
        //System.out.println("rpn = " + result.toString());
        return result.toString().replace(unarMinus, "-");
    }

    public static Var parseOneVar(String s) {
        Var var = null;
        Pattern pattern = Pattern.compile(patternFloat);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) var = new VarFloat(matcher.group());
        else {
            String[] rows = s.split(splitterMatrix);
            if (rows.length > 1) var = new VarMatrix(s);
            else var = new VarVector(s);
        }
        return var;
    }

    private static String readConsoleCommand() {
        return new Scanner(System.in).nextLine();
    }

    public static boolean parseConsoleCommand(Calc c) {
        String line = "";
        while (line != "END") {
            System.out.print("Enter command (printvar or sortvar; END to exit): ");
            line = readConsoleCommand();
            switch (line) {
                case "printvar": c.printVariables(); c.backupCalc("backup.txt"); break;
                case "sortvar": c.sortVariables(); break;
                case "END": return true;
                default:
                    System.out.println("Wrong command! Supported: printvar, sortvar; END to exit");
            }
        }
        return false;
    }

    public static HashMap<String, Var> readFile(String filename) {
        String src = System.getProperty("user.dir").concat("/src/by/it/savelyeva/matlab/");
        filename = src + filename;
        HashMap<String, Var> hm = new HashMap<String,Var>();
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] parts = line.replaceAll(" ", "").split("<->");
                hm.put(parts[0], parseOneVar(parts[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return hm;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(hm);
        return hm;
    }

}
