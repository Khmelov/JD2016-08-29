package by.it.rudzko.jd01_09;


import by.it.rudzko.jd01_09.Vars.Var;
import by.it.rudzko.jd01_09.Vars.VarMat;
import by.it.rudzko.jd01_09.Vars.VarNum;
import by.it.rudzko.jd01_09.Vars.VarVec;

import java.util.ArrayList;

public class Parser {
    private String str;
    private Var result;

    public Parser(String s) {
        setFrom(s);
    }

    private void setFrom(String s) {
        this.str = s;
    }

    public Var getResult() {
        return result;
    }

    Var go() {
        delSpaces();
        findBracket();
        System.out.println("Result is " + result + "\n");
        return result;
    }

    private void delSpaces() {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ')
                sb.deleteCharAt(i);
        }
        System.out.println("Expression: " + sb);
        sb.insert(0, '(');
        sb.append(')');
        str = sb.toString();

    }

    private void findBracket() throws RuntimeException {
        StringBuilder sb = new StringBuilder(str);
        int start = 0;
        int end = 0;
        while (brackets(str)) {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '(')
                    start = i + 1;

            }
            for (int j = start; j < sb.length(); j++) {
                if (sb.charAt(j) == ')') {
                    end = j;
                    break;
                }
            }
            String subStr = sb.substring(start, end);
            sb = sb.delete(start - 1, end + 1);
            Var v = calc(subStr);
            if (start > 1) {
                sb = sb.insert(start - 1, v.toString());
            } else {
                sb = sb.insert(0, v.toString());
            }
            str = sb.toString();
        }
        result = (str.charAt(0) != '{') ? new VarNum(str) : (str.charAt(1) != '{') ? new VarVec(str) : new VarMat(str);

    }

    private Var calc(String s) throws RuntimeException {
        Calculator get = new Calculator();
        String[] variables;
        Var res;
        while ((variables = s.split("[-+*/]")).length > 2) {
            ArrayList<String> oper = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+') oper.add("+");
                if (s.charAt(i) == '-') oper.add("-");
                if (s.charAt(i) == '*') oper.add("*");
                if (s.charAt(i) == '/') oper.add("/");
            }
            StringBuilder sb = new StringBuilder(s);
            int start = 0;
            int end = sb.length();
            Var r = null;
            for (int i = 0; i < oper.size(); i++) {
                String one = variables[i];

                Var first = (one.charAt(0) != '{') ? new VarNum(one) : (one.charAt(1) != '{') ? new VarVec(one) : new VarMat(one);
                String two = variables[i + 1];
                Var second = (one.charAt(0) != '{') ? new VarNum(two) : (one.charAt(1) != '{') ? new VarVec(two) : new VarMat(two);
                start = sb.indexOf(one);

                end = sb.indexOf(two) + two.length();
                switch (oper.get(i)) {
                    case "*":
                        r = get.mul(first, second);
                        break;
                    case "/":
                        r = get.div(first, second);
                        break;
                    case "+":
                        r = get.add(first, second);
                        break;
                    case "-":
                        r = get.sub(first, second);
                        break;
                    default:
                        System.out.println("Can't count.");
                }
                break;
            }
            s = sb.delete(start, end).insert(start, r.toString()).toString();
        }

        String one = variables[0];
        Var first = (one.charAt(0) != '{') ? new VarNum(one) : (one.charAt(1) != '{') ? new VarVec(one) : new VarMat(one);
        String two = variables[1];
        Var second = (two.charAt(0) != '{') ? new VarNum(two) : (two.charAt(1) != '{') ? new VarVec(two) : new VarMat(two);
        res = (s.contains("*")) ? get.mul(first, second) : (s.contains("/")) ? get.div(first, second) :
                (s.contains("+")) ? get.add(first, second) : get.sub(first, second);
        return res;
    }


    private static boolean brackets(String s) throws RuntimeException {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                return true;
            }
        }
        return false;
    }


}
