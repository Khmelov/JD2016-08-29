package by.it.laurynovich.jd01_05.math;

import static java.lang.Math.*;
/**
 * Created by vseotdala on 12.09.2016.
 */
public class Task_4 {
    public static double Math_04 ( ) {
        double d = 1;
        for (double t = 1; t <=3 ; t++) {
            for (double a = -5; a < 12; a+= 3.75) {
                d = d * sin(a - t);
            }
        }
        System.out.println("произведение  = " + d);
        return d;
    }
}

