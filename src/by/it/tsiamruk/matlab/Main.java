package by.it.tsiamruk.matlab;

import by.it.tsiamruk.matlab.operations.VarFOperations;
import by.it.tsiamruk.matlab.operations.VarVOperations;
import by.it.tsiamruk.matlab.vars.Var;
import by.it.tsiamruk.matlab.vars.VarF;
import by.it.tsiamruk.matlab.vars.VarV;




public class Main {
    private static void printOneVar(Var v) {
        if (v != null) System.out.println(v);
    }
    public static void main(String[] args) {

        System.out.println("\nпроверка +-*/ операций со скалярами");
        printOneVar(new VarFOperations("21").add(new VarFOperations("2")));
        printOneVar(new VarFOperations("55").sub(new VarFOperations("7")));
        printOneVar(new VarFOperations("4.6").mul(new VarFOperations("2")));
        printOneVar(new VarFOperations("-9").div(new VarFOperations("-1")));

        String vec = "{9,4,6}";
        System.out.println("\nпроверка  +-*/ операций с векторами справа и скалярами слева");
        printOneVar(new VarVOperations(vec).add(new VarF("2")));
        printOneVar(new VarVOperations(vec).sub(new VarF("1")));
        printOneVar(new VarVOperations(vec).mul(new VarF("2")));
        printOneVar(new VarVOperations(vec).div(new VarF("1")));

        System.out.println("\nпроверка  +-*/ операций со скалярами справа и векторами слева");
        printOneVar(new VarFOperations("1").add(new VarV(vec)));
        printOneVar(new VarFOperations("2").sub(new VarV(vec)));
        printOneVar(new VarFOperations("1").mul(new VarV(vec)));
        printOneVar(new VarFOperations("2").div(new VarV(vec)));

        System.out.println("\nпроверка  +-*/ операций с двумя векторами");
        printOneVar(new VarVOperations(vec).add(new VarV(vec)));
        printOneVar(new VarVOperations(vec).sub(new VarV(vec)));
        printOneVar(new VarVOperations(vec).mul(new VarV(vec)));
        printOneVar(new VarVOperations(vec).div(new VarV(vec)));

//        String string = "2.3 + 3 * 7 / 6";
//        Pattern p = Pattern.compile("[-]?\\d+\\.?\\d*|[\\w]+");
//        Matcher m = p.matcher(string);
//        Pattern p2 = Pattern.compile("[-+*/=]");
//        Matcher m2 = p2.matcher(string);
//        List values = new ArrayList<>();
//        List operations = new ArrayList<>();
//
//        while (m.find()) {
//            values.add(m.group());
//        }
//        while (m2.find()) {
//            operations.add(m2.group());
//        }
//


//        test success of adding elems to ArrayList
//        System.out.println(values.toString());
//        System.out.println(operations.toString());
//
//
//        Var f3 = new VarFOperations(arrayList.get(0));
//        Var f4 = new VarFOperations(arrayList.get(1));




    }
}

