package by.it.tsiamruk.matlab;

import by.it.tsiamruk.matlab.vars.Var;

import java.util.Scanner;


public class Main {
    private static void printOneVar(Var v) {
        if (v != null) System.out.println(v);
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        while ((line = scanner.nextLine()) != null) {
            if (line.toLowerCase().equals("exit"))
                System.exit(0);
            Var var = parser.calculation(line);
            System.out.println(var);
        }


//        System.out.println("\nпроверка +-*/ операций со скалярами");
//        printOneVar(new VarFOperations("21").add(new VarFOperations("2")));
//        printOneVar(new VarFOperations("55").sub(new VarFOperations("7")));
//        printOneVar(new VarFOperations("4.6").mul(new VarFOperations("2")));
//        printOneVar(new VarFOperations("-9").div(new VarFOperations("-1")));
//
//        String vec = "{9,4,6}";
//        System.out.println("\nпроверка  +-*/ операций с векторами справа и скалярами слева");
//        printOneVar(new VarVOperations(vec).add(new VarF("2")));
//        printOneVar(new VarVOperations(vec).sub(new VarF("1")));
//        printOneVar(new VarVOperations(vec).mul(new VarF("2")));
//        printOneVar(new VarVOperations(vec).div(new VarF("1")));
//
//        System.out.println("\nпроверка  +-*/ операций со скалярами справа и векторами слева");
//        printOneVar(new VarFOperations("1").add(new VarV(vec)));
//        printOneVar(new VarFOperations("2").sub(new VarV(vec)));
//        printOneVar(new VarFOperations("1").mul(new VarV(vec)));
//        printOneVar(new VarFOperations("2").div(new VarV(vec)));
//
//        System.out.println("\nпроверка  +-*/ операций с двумя векторами");
//        printOneVar(new VarVOperations(vec).add(new VarV(vec)));
//        printOneVar(new VarVOperations(vec).sub(new VarV(vec)));
//        printOneVar(new VarVOperations(vec).mul(new VarV(vec)));
//        printOneVar(new VarVOperations(vec).div(new VarV(vec)));
//
//        String matrix = "{(1.24,1.12,4.1)(1.23,4.13,5.33)(5.43,6.43,7.23)}";
//        System.out.println("\nпроверка +-*/ с матрицами и матрицами");
//        printOneVar(new VarMOperations(matrix).add(new VarM(matrix)));
//        printOneVar(new VarMOperations(matrix).sub(new VarM(matrix)));
//        printOneVar(new VarMOperations(matrix).mul(new VarM(matrix)));
//        printOneVar(new VarMOperations(matrix).div(new VarM(matrix)));
//
//        System.out.println("\nпроверка  +-*/ операций с матрицами справа и скалярами слева");
//        printOneVar(new VarMOperations(matrix).add(new VarF("2")));
//        printOneVar(new VarMOperations(matrix).sub(new VarF("1")));
//        printOneVar(new VarMOperations(matrix).mul(new VarF("2")));
//        printOneVar(new VarMOperations(matrix).div(new VarF("1")));
//
//        System.out.println("\nпроверка  +-*/ операций со скалярами справа и матрицами слева");
//        printOneVar(new VarFOperations("1").add(new VarM(matrix)));
//        printOneVar(new VarFOperations("2").sub(new VarM(matrix)));
//        printOneVar(new VarFOperations("1").mul(new VarM(matrix)));
//        printOneVar(new VarFOperations("2").div(new VarM(matrix)));
//
//        System.out.println("\nпроверка  +-*/ операций с матрицами справа и векторами слева");
//        printOneVar(new VarMOperations(matrix).add(new VarV(vec)));
//        printOneVar(new VarMOperations(matrix).sub(new VarV(vec)));
//        printOneVar(new VarMOperations(matrix).mul(new VarV(vec)));
//        printOneVar(new VarMOperations(matrix).div(new VarV(vec)));
//
//        System.out.println("\nпроверка  +-*/ операций с вектрами справа и матрицами слева");
//        printOneVar(new VarVOperations(vec).add(new VarM(matrix)));
//        printOneVar(new VarVOperations(vec).sub(new VarM(matrix)));
//        printOneVar(new VarVOperations(vec).mul(new VarM(matrix)));
//        printOneVar(new VarVOperations(vec).div(new VarM(matrix)));









    }
}

