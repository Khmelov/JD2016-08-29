package by.it.yarosh.jd01_05.math;


import static java.lang.Math.*;
/**
 * Created by Ил on 15.09.2016.
 */
public class Task4 {
    public static double proiz(){
        double n = 1;

        for (double t = 2; t <= 3; t += 0.1){
            for (int c = 12; c <= 43; c++){
                double f = pow(E, c-3);
                n=n*f;
            }
        }
        return n;
    }


}
