package by.it.emelyanov.jd01_05;

import static java.lang.Math.*;

public class Task2 {
    public static double funct(double a, double x) {
        double z;
        z = acos(pow(x, 2)) - a * sqrt(x / pow(a, 3)) + pow(sin(PI / 2), 3) / log(2 * x);
        return z;
    }
}
