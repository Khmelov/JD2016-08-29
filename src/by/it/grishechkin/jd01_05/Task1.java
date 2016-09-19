package by.it.grishechkin.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Yury on 19.09.2016.
 */
public class Task1 {
    public static double dissectedV (double a, double b) {
        double vA = tan(pow((a+b),2));
        double vB = -pow(a + 1.5,1/3);
        double vC = a*pow(b, 5);
        double vD = -(b)/(log(pow(a,2)));
        return vA + vB + vC + vD;
    }

    public static double fullV (double a, double b) {
        return tan(pow((a+b),2)) - pow(a + 1.5,1/3) + a*pow(b, 5) - (b)/(log(pow(a,2)));
    }
}
