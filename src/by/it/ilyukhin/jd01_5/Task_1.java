package by.it.ilyukhin.jd01_5;


import static java.lang.Math.*;

public class Task_1 {
    public static double variantA(double z) {
        double a = acos(pow(10.093, 2));
        double b = 0.94 * sqrt(10.093);
        double c = pow(sin((PI) / 2 + 0.94), 3);
        double d = log(2 * 10.093);
        z = (a - b) + c / d;
        return z;
    }

    public static double variantB(double z) {
        z = (acos(pow(10.093, 2)) - 0.94 * sqrt(10.093)) + (pow(sin((PI) / 2 + 0.94), 3) / (log(2 * 10.093)));
        return z;
    }
}
