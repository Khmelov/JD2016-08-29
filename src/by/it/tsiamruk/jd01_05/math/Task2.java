package by.it.tsiamruk.jd01_05.math;

import static java.lang.Math.*;

public class Task2 {
    public static double calculateFunction(double x){

        double y = pow(sin(x+1),2) + x * pow((3+pow(x,2)),1/4)/atan(x/2);

        return y;
    }
}
