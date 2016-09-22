package by.it.yarosh.jd01_05.math;

/**
 * Created by Ил on 13.09.2016.
 */
import static java.lang.Math.*;
public class Task2 {
    public static double funct(double a, double x){
        double z;
        z=log(abs((a-1.12*x)/4))-sqrt(x*pow(a,3));
        return z;

    }


}
