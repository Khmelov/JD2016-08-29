package by.it.rudzko.Matlab;


import by.it.rudzko.Matlab.Interfaces.IMessages;
import by.it.rudzko.Matlab.Interfaces.IVar;
import by.it.rudzko.Matlab.Vars.VarMat;
import by.it.rudzko.Matlab.Vars.VarNum;
import by.it.rudzko.Matlab.Vars.VarSelector;
import by.it.rudzko.Matlab.Vars.VarVec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Parser {
    private String str;
    private IVar result;

    private static HashMap<String,String> operations=new HashMap<String, String>(){
        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            int i=1;
            for (Entry<String, String> x : this.entrySet()) {
                sb.append(IMessages.UNDERLINED).append(i).append(IMessages.UNDERLINED).append("\n");
                sb.append(IMessages.DATA).append(x.getKey()).append("\n").append(IMessages.RESULT).append(x.getValue()).append("\n\n");
                i++;
            }
            return sb.toString();
        }
    };
    private String key=null;

    public static HashMap<String, String> getOperations() {
        return operations;
    }

    public Parser(String s) {
        setFrom(s);
    }

    private void setFrom(String s) {
        this.str = s;
    }

    public IVar getResult() {
        return result;
    }

    public IVar goParse() {
        format();
        findBracket();
        System.out.println("Result is " + result + "\n");
        operations.put(key, result.toString());
        return result;
    }

    private void format() {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ')
                sb.deleteCharAt(i);
        }
        System.out.println("Expression: " + sb);
        key=sb.toString();
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
            IVar v = calc(subStr);
            if (start > 1) {
                sb = sb.insert(start - 1, v.toString());
            } else {
                sb = sb.insert(0, v.toString());
            }
            str = sb.toString();
        }
        result = VarSelector.getVar(str);

    }

    private IVar calc(String s) throws RuntimeException {
        Calculator get = new Calculator();
        String[] variables;
        IVar res;
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
            IVar r = null;
            if (oper.contains("*")){
                int pos=oper.indexOf("*");
                String one = variables[pos];
                IVar first = VarSelector.getVar(one);
                String two = variables[pos + 1];
                IVar second = VarSelector.getVar(two);
                int findFrom=0;
                for (int i=0; i<pos; i++){
                    findFrom+=variables[i].length();
                }
                start = sb.indexOf(one, findFrom);
                end = sb.indexOf(two, start+one.length()) + two.length();
                r = get.mul(first, second);
            } else if(oper.contains("/")){
                int pos=oper.indexOf("/");
                String one = variables[pos];
                IVar first = VarSelector.getVar(one);
                String two = variables[pos + 1];
                IVar second = VarSelector.getVar(two);
                int findFrom=0;
                for (int i=0; i<pos; i++){
                    findFrom+=variables[i].length();
                }
                start = sb.indexOf(one, findFrom);
                end = sb.indexOf(two, start+one.length()) + two.length();
                r = get.div(first, second);
            }else {
                    String one = variables[0];
                    IVar first = VarSelector.getVar(one);
                    String two = variables[1];
                    IVar second = VarSelector.getVar(two);
                    int findFrom=variables[1].length();
                    start = sb.indexOf(one, findFrom);
                    end = sb.indexOf(two, start+one.length()) + two.length();
                    switch (oper.get(0)) {
                        case "+":
                            r = get.add(first, second);
                            break;
                        case "-":
                            r = get.sub(first, second);
                            break;
                        default:
                            System.out.println("Can't count.");
                    }
            }
            s = sb.delete(start, end).insert(start, r != null ? r.toString() : null).toString();
        }

        String one = variables[0];
        IVar first = VarSelector.getVar(one);
        String two = variables[1];
        IVar second = VarSelector.getVar(two);
        res = (s.contains("*")) ? get.mul(first, second) : (s.contains("/")) ? get.div(first, second) :
                (s.contains("+")) ? get.add(first, second) : get.sub(first, second);
        return res;
    }


    private static boolean brackets(String s) throws RuntimeException {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') {
                return true;
            }
        }
        return false;
    }


}
