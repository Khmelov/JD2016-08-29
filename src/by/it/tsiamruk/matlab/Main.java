package by.it.tsiamruk.matlab;


import by.it.tsiamruk.matlab.operations.VarFOperations;
import by.it.tsiamruk.matlab.vars.Var;


public class Main {
    public static void main(String[] args) {
        //task A
        Var f1 = new VarFOperations(3.8);
        Var f2 = new VarFOperations(26.2);
        System.out.println("Проверка + - * / с обычными(скалярными) числами:" + f1 + " " + f2);
        System.out.println(f1.add(f2));
        System.out.println(f1.sub(f2));
        System.out.println(f1.mul(f2));
        System.out.println(f1.div(f2));
        System.out.println(" ");

    }
}
