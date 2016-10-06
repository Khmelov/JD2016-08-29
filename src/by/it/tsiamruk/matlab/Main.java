package by.it.tsiamruk.matlab;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        //Var f1 = new VarFOperations(3.8);
        //Var f2 = new VarFOperations(26.2);

        String string = "2.3 + 3 * 7 / 6";
        Pattern p = Pattern.compile("[-]?\\d+\\.?\\d*|[\\w]+");
        Matcher m = p.matcher(string);
        Pattern p2 = Pattern.compile("[-+*/=]");
        Matcher m2 = p2.matcher(string);
        List values = new ArrayList<>();
        List operations = new ArrayList<>();

        while (m.find()) {
            values.add(m.group());
        }
        while (m2.find()) {
            operations.add(m2.group());
        }


        //test success of adding elems to ArrayList
        //System.out.println(values.toString());
        //System.out.println(operations.toString());


        //Var f3 = new VarFOperations(arrayList.get(0));
        //Var f4 = new VarFOperations(arrayList.get(1));


        //System.out.println("Проверка + - * / с обычными(скалярными) числами:" + f3 + " " + f4);
        //System.out.println(f1.add(f2));
        //System.out.println(f1.sub(f2));
        //System.out.println(f1.mul(f2));
        //System.out.println(f1.div(f2));
        //System.out.println("");

    }
}

