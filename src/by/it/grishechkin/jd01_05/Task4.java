package by.it.grishechkin.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Yury on 19.09.2016.
 */
public class Task4 {
    public static void mySum(double x1, double x2, double dx) {
        double buff = x1;
        double rez;
        System.out.println("\ttd\t  rez");
        do {
            rez = 0;
            for (int i = 6; i < 12 ; i++) {
                rez += pow(buff, 5 + 1.3 * i);
            }
            System.out.printf("%1$+5.3f \t%2$+5.3f", buff, rez);
            System.out.println();
            buff += dx;
        }
        while (buff - dx <= x2);
    }
}
