package by.it.emelyanov.jd02_04.parser;

import by.it.emelyanov.jd02_04.vars.VarF;
import by.it.emelyanov.jd02_04.vars.VarV;
import by.it.emelyanov.jd02_04.vars.Variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final String[] levelOperation = {"=", "+", "-", "*", "/"};
    private ArrayList<String> strVar = new ArrayList<>();
    private ArrayList<String> operation = new ArrayList<>();

    public Variable getResult() {
        return result;
    }

    private Variable result;


    public Variable calc(String str) {
        str = str.replaceAll("\\+-", "+MINUS");
        str = str.replaceAll("\\*-", "*MINUS");
        str = str.replaceAll("--", "-MINUS");
        str = str.replaceAll("/-", "/MINUS");
        str = str.replaceAll("\\s", "");

        String[] vars = str.split("[-+*/]");
        for (int i = 0; i < vars.length; i++) {
            vars[i] = vars[i].replace("MINUS", "-");
        }
        strVar = new ArrayList<>(Arrays.asList(vars));

        Pattern p = Pattern.compile("[-+*/]");
        Matcher matcher = p.matcher(str);
        while (matcher.find()) {
            String op = matcher.group(0);
            operation.add(op);
        }

        while (operation.size() > 0) {
            int i = findOpNumber();
            oneOperation(i);
        }

        result = parseOneVar(strVar.get(0));

        return result;
    }

    private int getPrioritet(String oneOperation) {
        int result = -1;
        for (int j = 0; j < levelOperation.length; j++) {
            if (oneOperation.equals(levelOperation[j]) && result < j)
                result = j;
        }
        return result;
    }

    private int findOpNumber() {
        int result = -1;
        int bestLevel = -1;
        for (int i = 0; i < operation.size(); i++) {
            int iLevel = getPrioritet(operation.get(i));
            if (iLevel > bestLevel) {
                bestLevel = iLevel;
                result = i;
            }
        }
        return result;
    }

    private Variable parseOneVar(String strVar) {
        if (strVar.matches("-?[0-9.]+")) return new VarF(strVar);
        else if (strVar.matches("\\{.+}")) return new VarV(strVar);
        else return null;
    }

    private void oneOperation(int number) {

        Variable result = null;
        String oper = operation.get(number);
        Variable one = parseOneVar(strVar.get(number));
        assert one != null;
        Variable two = parseOneVar(strVar.get(number + 1));
        assert two != null;
        if (oper.equals("+")) result = one.add(two);
        if (oper.equals("-")) result = one.sub(two);
        if (oper.equals("*")) result = one.mul(two);
        if (oper.equals("/")) result = one.div(two);
        operation.remove(number);
        strVar.remove(number);
        strVar.set(number, String.valueOf(result));
    }

}
