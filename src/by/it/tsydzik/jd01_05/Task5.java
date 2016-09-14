package by.it.tsydzik.jd01_05;

import static java.lang.Math.*;

/**
 * Created by user on 12.09.2016.
 */
public class Task5 {
    public static void compute() {
        double r = 4.73;
        double del = 3.5;
        double x;
        for (double p = 4; p < 20d; p += del) {
            if (pow(p, 2) < 5) {
                x = pow(sin(p), 2);
            } else if (pow(p, 2) >= 5 && pow(p, 2) < 13) {
                x = pow(7, p + 3);
            } else if (pow(p, 2) > 13) {
                x = log(abs(pow(p + 4.7, 5)));
            } else {
                continue;
            }
            System.out.println(x + r / 2);
        }
    }
}
