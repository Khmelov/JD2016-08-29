package by.it.tsiamruk.matlab;


import by.it.tsiamruk.matlab.operations.VarFOperations;
import by.it.tsiamruk.matlab.vars.Var;


public class Main {
    public static void main(String[] args) {
        Var f1 = new VarFOperations(3.8);
        Var f2 = new VarFOperations(26.2);
        Var sub1 = new VarFOperations(87.4);
        Var sub2 = new VarFOperations(23.1);
        Var mn1 = new VarFOperations(12.7);
        Var mn2 = new VarFOperations(5);
        Var delim1 = new VarFOperations(-9);
        Var delim2 = new VarFOperations(2);
        System.out.println("Проверка + - * / с обычными(скалярными) числами:" + f1 + " " + f2);
        System.out.println(f1.add(f2));
        System.out.println(sub1.sub(sub2));
        System.out.println(mn1.mul(mn2));
        System.out.println(delim1.div(delim2));
        System.out.println(" ");

    }
}
