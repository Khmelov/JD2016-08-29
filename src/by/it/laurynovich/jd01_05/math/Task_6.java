package by.it.laurynovich.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by vseotdala on 12.09.2016.
 */
public class Task_6 {
    public static double [] Math06(double a, double b){
        double step;
        step = (b - a )/20;
        double[] s = new double[20];
        double i = a;
        double p = 0;
        double averMult = 1;

            for (int j = 0; j < 20 ; j++) {
                s[j] = asin(i/3.0);
                i += step;
                //System.out.println("elem № " + j + " = "+ s[j]);
                System.out.println(String.format("%-2s%-5s%-2s%-22s%-20s", "┃", j, "┃", s[j], "┃"));

                if (j%2 != 0){
                   p++;
                    averMult = averMult * s[j];
                }
            }
            double averGeom = pow(averMult, p);
        System.out.println("среднее геометрическое = " + averGeom);
        System.out.println("количество нечетных элементов  = " + p);

        return s;

    }
}
