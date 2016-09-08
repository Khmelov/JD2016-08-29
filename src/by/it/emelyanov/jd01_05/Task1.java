package by.it.emelyanov.jd01_05;

import static java.lang.Math.*;

public class Task1 {
    public static double separ(double a, double x) {
        double b, c, d, e, z;
        b = acos(pow(x, 2));
        c = a * sqrt(x);
        d = pow(sin(PI / 2 + a), 3);
        e = log(2 * x);
        z = b - c + d / e;
        return z;
    }

    public static double tog(double a, double x) {
        double z;
        z = acos(pow(x, 2)) - a * sqrt(x) + pow(sin(PI / 2 + a), 3) / log(2 * x);
        return z;
    }
}
