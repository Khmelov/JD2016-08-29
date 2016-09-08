package by.it.emelyanov.jd01_05;

import static java.lang.Math.*;

public class Task5 {
    public static void funct2() {
        double b;
        for (double x = -0.3; x < 0.2; x += 0.1) {
            if (4 * x > -2 && 4 * x <= -1) {
                b = pow(sin(x + 1), 3);
            } else if (4 * x > -1 && 4 * x < 0.2) {
                b = cos(pow(x, 2) + pow(3.12, 0.3));
            } else if (4 * x > 0.2) {
                b = pow(tan(x), 4);
            } else {
                continue;
            }
            double m = pow(abs(5 * pow(b, 6)), 1 / 3) + pow(E, abs(b - 2.04));
            System.out.println(String.format("%1s%25s", x, m));
        }
    }
}
