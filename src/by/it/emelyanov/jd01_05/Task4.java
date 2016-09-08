package by.it.emelyanov.jd01_05;

import static java.lang.Math.*;

public class Task4 {
    public static double proiz() {
        double m = 1;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int c = 2; c <= 8; c++) {
                double f = pow(E, c) - 2.11 * a;
                m = m * f;
            }
        }
        return m;
    }
}
