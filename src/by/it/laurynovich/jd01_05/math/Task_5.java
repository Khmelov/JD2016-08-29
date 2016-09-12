package by.it.laurynovich.jd01_05.math;

import static java.lang.Math.*;
/**
 * Created by vseotdala on 12.09.2016.
// */
public class Task_5 {
    public static double Math05(double r){
        double x = 0, z;
        for (double p = -8; p < 22 ; p += 3.5) {
            if (p + r < 0.5) {
                x = pow(sin(p), 5);
            }
            if (0.5 <= (p + r) && (p + r) < 3){
                x = pow(E, abs(p + 3));
            }
            if ((p + r) > 3){
                x = pow(abs(p + 3),1.5);
            }
        }
        z = (2 * x) - (pow(E, r) / 2);
        return z;
    }

}
