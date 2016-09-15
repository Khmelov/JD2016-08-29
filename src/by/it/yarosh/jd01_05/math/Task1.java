package by.it.yarosh.jd01_05.math;

/**
 * Created by Ил on 12.09.2016.
 */
import static java.lang.Math.*;
public class Task1 {

    public static double  separ(double a, double b){
        double c, d, e, f, g;
        c=tan(pow(a+b,2));
        d=sqrt(a+1.5);
        e=a*pow(b,5);
        f=b/log(pow(a,2));
        g=c-d+e-f;
        return g;
    }
    public static double tog(double a, double b) {
        double g;
        g = tan(pow(a + b, 2)) - sqrt(a + 1.5) + a * pow(b, 5) - b / log(pow(a, 2));
        return g;
    }
}
