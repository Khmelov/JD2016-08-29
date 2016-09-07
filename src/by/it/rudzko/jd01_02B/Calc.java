package by.it.rudzko.jd01_02B;

import java.util.Scanner;

/**
 * Created by Kir on 05.09.2016.
 */
public class Calc {
    public static void solveEq() {
        System.out.println("Now I'm going to solve the quadratic equation for you. Please enter the first factor.");
        double a = Double.valueOf(new Scanner(System.in).nextLine());
        System.out.println("Please enter the second factor.");
        double b = Double.valueOf(new Scanner(System.in).nextLine());
        System.out.println("Please enter the third factor.");
        double c = Double.valueOf(new Scanner(System.in).nextLine());
        double dis = b * b - 4 * a * c;
        if (dis > 0.0d) {
            double x1 = (Math.sqrt(dis) - b) / a / 2.0d;
            double x2 = (-b - Math.sqrt(dis)) / a / 2.0d;
            System.out.println("Results are " + x1 + " and " + x2 + ".");
        } else if (dis == 0.0d) {
            double x = -b / a / 2.0d;
            System.out.println("Result is " + x + ".");
        } else System.out.println("There're no results for such equation.");
    }
}
