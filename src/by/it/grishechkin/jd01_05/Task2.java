package by.it.grishechkin.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Yury on 19.09.2016.
 */
public class Task2 {
    public static double calc (double a, double x) {
        return -sqrt(x * pow(a, 3)) + log(abs((a - 1.12 * x)/(4)));
    }
}
