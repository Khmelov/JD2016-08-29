package by.it.savelyeva.jd_01_05.math;

/**
 * Created by nato on 9/7/16.
 */
public class Task4 {

    public static double calculateZ(double a, double leftBoundB, double rightBoundB, double deltaB) {
        int i = 0;
        double sum = 0, b = leftBoundB;
        while (b <= rightBoundB) {
            i++;
            sum = 0;
            for (int c=1; c<=12; c++) {
                sum += c - b;
            }
            b += deltaB;
        }
        return 1.38 * a + sum;
    }

}
