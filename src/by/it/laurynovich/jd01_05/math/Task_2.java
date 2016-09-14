package by.it.laurynovich.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by vseotdala on 11.09.2016.
 */
public class Task_2 {
    public static double MathT2 (double a, double x){
        double z = atan(pow(x, 2)) + (pow(cos(PI/2 - a), 3))/ abs(x - pow(a, 1/5));
        return z;
    }
}
