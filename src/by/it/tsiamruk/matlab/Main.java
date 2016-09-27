package by.it.tsiamruk.matlab;


import by.it.tsiamruk.matlab.operations.VarFOperations;
import by.it.tsiamruk.matlab.vars.Var;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        //task A
        //Var f1 = new VarFOperations(3.8);
        //Var f2 = new VarFOperations(26.2);
        String str = "2.8 + 3";
        Pattern p = Pattern.compile("[\\-]*[\\d][\\.]*[\\d]*");
        Matcher m = p.matcher(str);

        ArrayList<String> arrayList = new ArrayList<>();
        while (m.find()){
            arrayList.add(m.group());
        }
        //testing sucsess of add elements to ArrayList
        //System.out.println(arrayList.toString());
        Var f1 = new VarFOperations(arrayList.get(0));
        Var f2 = new VarFOperations(arrayList.get(1));


        System.out.println("Проверка + - * / с обычными(скалярными) числами:" + f1 + " " + f2);
        System.out.println(f1.add(f2));
        System.out.println(f1.sub(f2));
        System.out.println(f1.mul(f2));
        System.out.println(f1.div(f2));
        System.out.println(" ");



    }
}
