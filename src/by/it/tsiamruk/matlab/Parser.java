package by.it.tsiamruk.matlab;

import by.it.tsiamruk.matlab.operations.VarFOperations;
import by.it.tsiamruk.matlab.operations.VarMOperations;
import by.it.tsiamruk.matlab.operations.VarVOperations;
import by.it.tsiamruk.matlab.vars.Var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by waldemar on 18/10/2016.
 */
public class Parser {
    //operations
    private final String[] levelOperation = {"=", "+", "-", "*", "/"};
    //value to calculate
    private ArrayList<String> values = new ArrayList<>();
    private ArrayList<String> operations = new ArrayList<>();
    //result
    private Var result;

    public Var getResult() {
        return result;
    }


    /**
     * Method parse operands to calculation.
     *
     * @param line this is string. From it method parse operands to calculate
     */
    public void getValues(String line) {
        Pattern findOperands = Pattern.compile(Patterns.exAny);
        Matcher find = findOperands.matcher(line);
        while (find.find()) {
            values.add(find.group());
        }
    }

    /**
     * Method parse operations to calculation.
     *
     * @param line from this string we get operations.
     */
    public void getOperations(String line) {
        Pattern findOperations = Pattern.compile(Patterns.exOper);
        Matcher find = findOperations.matcher(line);
        while (find.find()) {
            operations.add(find.group());
        }
    }

    /**
     * Method to getting priority of operations.
     *
     * @param line This is string, from it method reads operaions and get priority.
     * @return priority of operation.
     */
    public int getPriority(String line) {
        int result = -1;
        for (int j = 0; j < levelOperation.length; j++) {
            if (line.equals(levelOperation[j]) && result < j)
                result = j;
        }
        return result;
    }

    public int findMaxPriority() {
        int result = -1;
        int bestLevel = -1;
        for (int i = 0; i < operations.size(); i++) {
            int iLevel = getPriority(operations.get(i));
            if (iLevel > bestLevel) {
                bestLevel = iLevel;
                result = i;
            }
        }
        return result;
    }

    private Var parseVar(String line) {
        if (line.matches(Patterns.exVal)) return new VarFOperations(line);
        if (line.matches(Patterns.exVec)) return new VarVOperations(line);
        if (line.matches(Patterns.exMat)) return new VarMOperations(line);
        else return null;
    }

    private void oneOperation(int num) {
        Var one = parseVar(values.get(num));
        Var two = parseVar(values.get(num + 1));
        Var result = null;
        String operation = operations.get(num);
        if (one != null) {
            if (operation.equals("+")) result = one.add(two);
            if (operation.equals("-")) result = one.sub(two);
            if (operation.equals("*")) result = one.mul(two);
            if (operation.equals("/")) result = one.div(two);
            operations.remove(num);
            values.remove(num);
            values.set(num, String.valueOf(result));
        }
    }

    public Var calculation(String line) {
        //временная замена минусов на свой вариант(?)
        line = line.replaceAll("\\+-", "+MINUS");
        line = line.replaceAll("\\*-", "*MINUS");
        line = line.replaceAll("--", "-MINUS");
        line = line.replaceAll("/-", "/MINUS");
        //удаление всех пробелов и табуляций и тому подобного
        line = line.replaceAll("\\s", "");
        // разбор на операнды
        String[] operands = line.split(Patterns.exOper);
        //возвращаем минусы
        for (int i = 0; i < operands.length; i++) {
            operands[i] = operands[i].replace("MINUS", "-");
        }
        //коллекция операнд
        values = new ArrayList<>(Arrays.asList(operands));
        //коллекция операций
        getOperations(line);

        //производим вычесление
        while (operations.size() > 0) {
            int i = findMaxPriority();
            oneOperation(i);
        }

        result = parseVar(values.get(0));

        return result;
    }


}
