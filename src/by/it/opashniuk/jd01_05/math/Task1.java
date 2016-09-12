package by.it.opashniuk.jd01_05.math;

import static java.lang.Math.*;

public class Task1 {

    public static double variantA(double x) {
        double a=756.13;

        double partOne=pow(cos(pow(x,2+PI/6)),5);
        double partTwo=pow((x*pow(a,3)),0.5);
        double partThree=log(abs((a-1.12*x)/4));

        double z=partOne-partTwo-partThree;
        return z;
    }

    public static double variantB(double x) {
        double a=756.13;

        double z=pow(cos(pow(x,2+PI/6)),5)-pow((x*pow(a,3)),0.5)-log(abs((a-1.12*x)/4));
        return z;
    }
}
