package by.it.tsiamruk.jd01_05.math;

import static java.lang.Math.*;

public class Task1 {
      public static double firstTaskPartByPart(){

        double x = 3.24;
        double a = 5.8;

        double firstPart = atan(pow(x,2))-sqrt((x+pow(143,3)));
        double secondPart = cos((PI/2*a))/abs((x-pow(a,1/5)));

        double z = firstPart + secondPart;

        return z;

    }//end of firstTask method.

    public static double firstTaskWholeExpression(){

        double x = 3.24;
        double a = 5.8;

        double z = atan(pow(x,2))-sqrt(x+pow(143,3)) + cos(PI/2*a)/abs(x-pow(a,1/5));

        return z;

    }//end of WholeExpression method.
}//end of Task1 class.
