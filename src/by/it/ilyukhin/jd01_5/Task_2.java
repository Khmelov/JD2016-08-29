package by.it.ilyukhin.jd01_5;


import java.util.Scanner;

import static java.lang.Math.pow;

public class Task_2 {
    public static double calculateA(double x, double a) {
        double z;
        z = Math.acos(pow(x, 2)) - (a * (Math.sqrt(x / pow(a, 3)))) + (pow(Math.sin(Math.PI / 2), 3) / Math.log(2 * x));
        return z;
    }

    public static double calculateB() {
        System.out.println("Введите значение a");
        Scanner inputA = new Scanner(System.in);
        double a = inputA.nextDouble();
        System.out.println("Введите значение x");
        Scanner inputX = new Scanner(System.in);
        double x = inputX.nextDouble();
        double z;
        z = Math.acos(pow(x, 2)) - (a * (Math.sqrt(x / pow(a, 3)))) + (pow(Math.sin(Math.PI / 2), 3) / Math.log(2 * x));
        return z;
    }
}
