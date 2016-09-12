package by.it.laurynovich.jd01_05.math;

import static java.lang.Math.*;
/**
 * Created by vseotdala on 11.09.2016.
 */
public class Task_1 {

    //double x = 10.093;

    public static double MathA1(double x, double a){

        double p = acos(pow(a, 2));
        double q = a * sqrt(x);
        double r = pow(sin(PI/2 + a), 3);
        double s = log10(2 * x);

        double z = p - q + r/s;
        return z;
    }

    public static double MathA2 (double x, double a){
        double z = acos(pow(a, 2)) - a * sqrt(x) + (pow(sin(PI/2 + a), 3))/log10(2 * x);
        return z;

    }

}
