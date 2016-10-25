package by.it.artiuschik.mathlab.utils;

import by.it.artiuschik.mathlab.Runner;
import by.it.artiuschik.mathlab.data.ApplicationData;
import by.it.artiuschik.mathlab.errors.IncorrectBracketsException;
import by.it.artiuschik.mathlab.operations.Calculator;
import by.it.artiuschik.mathlab.vars.Var;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final String[] levelOperation = {"=", "+", "-", "*", "/"};   //таблица приоритетов операций
    //переменные
    private ArrayList<String> strVar = new ArrayList<>();                  //переменные
    private ArrayList<String> operation = new ArrayList<>();               //операции

    //получить приоритет операции
    private int getPrioritet(String oneOperation) {
        int result = -1;
        for (int j = 0; j < levelOperation.length; j++) {
            if (oneOperation.equals(levelOperation[j]) && result < j)//result<j?
                result = j;
        }
        return result;
    }

    private int findOpNumber() { //ищет самую приоритетную операцию (ее номер в массиве)
        int result = -1;//номер в массиве
        int bestLevel = -1;//приоритет операции
        for (int i = 0; i < operation.size(); i++) {
            int iLevel = getPrioritet(operation.get(i));
            if (iLevel > bestLevel) {
                bestLevel = iLevel;
                result = i;
            }
        }
        return result;
    }

    private Var parseOneVar(String strVar) { //находит одну переменную
        if (!strVar.matches(Patterns.varName)) {
            return ApplicationData.creator.createVar(strVar);
        } else {
            if (ApplicationData.vars.containsKey(strVar)) {
                //если переменная есть в hashmap
                return ApplicationData.vars.get(strVar);//достаем ее значение
            } else {
                /*если с незнакомой переменной не будет
                проводится только операция присваивания
                 */
                if (!((operation.size() == 1) && (operation.get(0).equals("=")))) {
                    Runner.logger.writeToLogfile("Error! неициализированная переменная!", "log.txt");
                    return null;
                } else {
                    //с незнакомой переменной проводится только операция присваивания
                    ApplicationData.vars.put(strVar, new Var());
                    return ApplicationData.vars.get(strVar);
                }
            }
        }
    }

    private void oneOperation(int number) throws Exception { //выполняет одну операцию

        Var result = null;
        String oper = operation.get(number);
        String strOne = strVar.get(number);
        Var one = parseOneVar(strOne);
        assert one != null;
        String strTwo = strVar.get(number + 1);
        Var two = parseOneVar(strTwo);
        assert two != null;
        if (oper.equals("+")) {
            result = Calculator.add(one, two);
        }
        if (oper.equals("-")) {
            result = Calculator.sub(one, two);
        }
        if (oper.equals("*")) {
            result = Calculator.mul(one, two);
        }
        if (oper.equals("/")) {
            result = Calculator.div(one, two);
        }
        if (oper.equals("=")) {
            ApplicationData.vars.put(strOne, two);
            result = two;
        }
        operation.remove(number);
        strVar.remove(number);
        strVar.set(number, String.valueOf(result));
    }

    private boolean isBracketsCorrect(String str) {
        Stack<Character> bracketsStack = new Stack<>();
        try {
            for (int i = 0; i < str.length(); i++) {//проход по всем символам строки
                char c = str.charAt(i);
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        bracketsStack.push(c);
                        break;
                /*как только встретили закрывающую скобку-проверяем была ли перед ней
                открывающая-она должна быть на верхушке стека
                 */
                    case ')':
                        if (bracketsStack.pop() != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if (bracketsStack.pop() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (bracketsStack.pop() != ']') {
                            return false;
                        }
                        break;
                }
            }
            return bracketsStack.isEmpty();//если стек пустой, то все корректно
        } catch (EmptyStackException e) {
            return false;//пытались найти открывающую скобку, а стек пуст
        }
    }

    private Var calcWithoutBrackets(String str) throws Exception {
        //временная замена минусов на свой вариант
        //A=6*-4
        str = str.replaceAll("\\+-", "+MINUS");
        str = str.replaceAll("\\*-", "*MINUS");
        str = str.replaceAll("--", "-MINUS");
        str = str.replaceAll("/-", "/MINUS");

        //удаление всех пробелов и пробельных символов
        str = str.replaceAll("\\s", "");

        //разбор выражения на отдельные операции и операнды

        String[] vars = str.split(Patterns.exOperation);
        //возвращаем минусы "на родину"
        for (int i = 0; i < vars.length; i++) {
            vars[i] = vars[i].replace("MINUS", "-");
        }
        //создаем коллекцию переменных в виде строк
        strVar = new ArrayList<>(Arrays.asList(vars));

        //создаем коллекцию операций в виде строк
        Pattern p = Pattern.compile(Patterns.exOperation);
        Matcher matcher = p.matcher(str);
        while (matcher.find()) {
            String op = matcher.group(0);
            operation.add(op);
        }

        while (operation.size() > 0) {
            int i = findOpNumber(); //нашли наиболее высокоприоритетную операцию
            //debug();
            oneOperation(i); //выполнили ее
        }

        //операций больше нет. возвращаем итог расчетов
        return parseOneVar(strVar.get(0));
    }

    public Var calc(String str) throws Exception {
        StringBuilder sb = new StringBuilder(str.replaceAll("\\s", ""));
        if (isBracketsCorrect(sb.toString())) {
            Pattern p = Pattern.compile(Patterns.innerBrackets);
            Matcher m = p.matcher(sb);
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                String s = m.group();
                String strWithoutBr = s.replaceAll("[\\(\\)]", "");
                sb.delete(start, end);
                sb.insert(start, calcWithoutBrackets(strWithoutBr));
                m.reset(sb);
            }
            return calcWithoutBrackets(sb.toString());
        } else {
            throw new IncorrectBracketsException("Brackets in expression are incorrect");
        }

    }


}
