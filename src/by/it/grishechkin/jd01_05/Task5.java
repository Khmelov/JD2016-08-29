package by.it.grishechkin.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Yury on 19.09.2016.
 */
public class Task5 {

    public static void func(double p1, double p2, double dp) {
        double y;
        double p = p1;
        double r = 4.73;
        System.out.println("\tp\t  x");
        do {
            if (p + r < 0.5) {
                y = pow(sin(p), 5);
            } else if (p + r >= 0.5 && p + r < 3) {
                y = exp(abs(p + 2));
            } else {
                y = sqrt(abs(pow((p + 7), 5)));
            }
            System.out.printf("%1$+5.3f \t%2$+5.3f", p, y);
            System.out.println();
            p += dp;
        }
        while (p <= p2);
    }
}
