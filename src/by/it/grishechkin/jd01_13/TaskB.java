package by.it.grishechkin.jd01_13;

/**
 * Created by Yury on 21.10.2016.
 */
public class TaskB {

    public static void oneDiv(int a, int b) throws ArithmeticException {
        System.out.println("Begin");
        double rez1;
        try {
            rez1 = a/b;
            System.out.println("a/b = " + rez1);
        }
        catch (ArithmeticException e) {
            e = new ArithmeticException("Деление на нуль");
            System.err.println(e.getMessage());
        }
        try {
            twoDiv(a,b);
        }
        catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("End");
    }

    public static void twoDiv(int a, int b) throws ArithmeticException {
        System.out.println("Begin");
        double rez2;
        try {
            rez2 = (a*a)/b;
            System.out.println("a^2/b = " + rez2);
        }
        catch (ArithmeticException e) {
            e = new ArithmeticException("Деление на нуль");
            System.err.println(e.getMessage());
        }
        try {
            threeDiv(a,b);
        }
        catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("End");
    }

    public static void threeDiv(int a, int b) throws ArithmeticException {
        System.out.println("Begin");
        double rez3;
        try {
            rez3 = (a*a*a)/b;
            System.out.println("a^3/b = " + rez3);
        }
        catch (ArithmeticException e) {
            e = new ArithmeticException("Деление на нуль");
            System.err.println(e.getMessage());
        }
        if (a < 0) {
            throw new ArithmeticException("Корень из отрицательного числа");
        }
        else {
            System.out.println("Корень из a = " + Math.sqrt((double) a));
        }
        System.out.println("End");
    }
}
