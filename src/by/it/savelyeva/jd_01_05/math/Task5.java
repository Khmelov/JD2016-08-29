package by.it.savelyeva.jd_01_05.math;

/**
 * Created by nato on 9/7/16.
 */
public class Task5 {

    public static void calculateAlpha(double leftBoundX, double rightBoundX, double deltaX) {
        double alpha;
        int i = 0;
        double x = leftBoundX;
        while (x <= rightBoundX) {
            i++;
            double beta = 0;
            double t = x/2;
            if (t>-2 && t<=-1) {
                beta = Math.sin(x*x);
            } else if (t>-1 && t<0.2) {
                beta = Math.cos(x*x);
            } else if (0.2==t) {
                beta = 1/Math.tan(x*x);
            }
            alpha = Math.log10(Math.abs(beta + 2.74));
            System.out.printf("iteration %d (x = %.2f, t = %.2f): alpha = %10.6f\n", i, x, t, alpha);
            x += deltaX;
        }
    }

}
