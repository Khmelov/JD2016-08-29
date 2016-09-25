package by.it.emelyanov.jd01_09;

import by.it.emelyanov.jd01_09.abstraction.Variable;
import by.it.emelyanov.jd01_09.operation.VarFOper;
import by.it.emelyanov.jd01_09.operation.VarVOper;


public class Runner {
    private static void one(Variable v) {
        if (v != null) System.out.println(v);
    }

    public static void main(String[] args) {
        System.out.println("Проверка операций со скалярами");
        one(new VarFOper("1").add(new VarFOper("2")));
        one(new VarFOper("9").sub(new VarFOper("7")));
        one(new VarFOper("1.5").mul(new VarFOper("2")));
        one(new VarFOper("-4").div(new VarFOper("-1")));

        String v = "{1,2,3}";
        System.out.println("\nВектор справа и скаляр слева:");
        one(new VarVOper(v).add(new VarFOper("2")));
        one(new VarVOper(v).sub(new VarFOper("1")));
        one(new VarVOper(v).mul(new VarFOper("2")));
        one(new VarVOper(v).div(new VarFOper("1")));

        System.out.println("\nСкаляр справа и вектор слева:");
        one(new VarFOper("1").add(new VarVOper(v)));
        one(new VarFOper("2").sub(new VarVOper(v)));
        one(new VarFOper("1").mul(new VarVOper(v)));
        one(new VarFOper("2").div(new VarVOper(v)));

        System.out.println("\nОперации с двумя векторами");
        one(new VarVOper(v).add(new VarVOper(v)));
        one(new VarVOper(v).sub(new VarVOper(v)));
        one(new VarVOper(v).mul(new VarVOper(v)));
        one(new VarVOper(v).div(new VarVOper(v)));
    }

}
