package by.it.grishechkin.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Yury on 19.09.2016.
 */
public class Util {

    public static double[] addArr(double x1, double x2, double dx) {
        double[] arr = new double[(int) floor(x2/dx) + 2];
        double buff = x1;
        int iter = 0;
        do {
            arr[iter] = Task6.calc(buff);
            buff += dx;
            iter++;
        }
        while (buff - dx <= x2);
        return arr;
    }
}
