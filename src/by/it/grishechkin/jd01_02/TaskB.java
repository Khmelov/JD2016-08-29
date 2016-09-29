package by.it.grishechkin.jd01_02;

import java.util.Scanner;

/**
 * Created by Yury on 14.09.2016.
 */
public class TaskB {

    public  static boolean isOnInterval(int k, int n, int m) {
        System.out.println("Number " + k + " belongs interval: ( " + n + ", " + m + " )");
        if (k > n && k < m) return true;
        else return false;
    }

    public static void matrixPrint (int k) {
        int n = (int) Math.sqrt(k);
        int iter = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("\t" + iter);
                iter++;
            }
            System.out.println();
        }
    }

    public static void solve () {
        double a, b, c;
        double D;

        System.out.println("Программа решает квадратное уравнение вида:");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Введите a, b и c:");

        Scanner in = new Scanner(System.in);

        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();

        D = b * b - 4 * a * c;
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
        }
        else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Уравнение имеет единственный корень: x = " + x);
        }
        else {
            System.out.println("Уравнение не имеет действительных корней!");
        }
    }

    public static void mounth (int month) {

            switch (month) {
                case 2:  System.out.println("February");    break;
                case 3:  System.out.println("March");       break;
                case 4:  System.out.println("April");       break;
                case 5:  System.out.println("May");         break;
                case 6:  System.out.println("June");        break;
                case 7:  System.out.println("July");        break;
                case 8:  System.out.println("August");      break;
                case 9:  System.out.println("September");   break;
                case 10:  System.out.println("October");     break;
                case 11: System.out.println("November");    break;
                case 12: System.out.println("December");    break;
                case 1: System.out.println("January");     break;
                default: System.out.println("No number");   break;

        }

    }
}
