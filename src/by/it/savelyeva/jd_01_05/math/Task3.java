package by.it.savelyeva.jd_01_05.math;

/**
 * Created by nato on 9/7/16.
 */
public class Task3 {

    public static void tabulateY(double x, double leftBoundA, double rightBoundA, double deltaA) {
        System.out.printf("Tabulated y, %.1f <= a <= %.1f, delta = %.12f:\n", leftBoundA, rightBoundA, deltaA);
        int i = 0;
        double a = leftBoundA;
        while (a <= rightBoundA) {
            i++;
            System.out.printf("iteration %d (a = %.2f): y = %10.6f\n", i, a, 1/Math.tan(Math.pow(x, 3)) + 2.24 * a * x);
            a += deltaA;
        }
    }

}
