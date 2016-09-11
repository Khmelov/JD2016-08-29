package by.it.senchenko.jd01_05;

import java.lang.Math.*;

import static java.lang.StrictMath.*;

public class Main2 {
    public static void main(String[] args){
        double y;
        double a = 1.21;
        double b = 0.371;

        y= pow(tan(a+b),2)-pow((a+1.5),(1/3))+a*pow(b,5)-(b/log(a*a));
        System.out.println(y);

    }
}
