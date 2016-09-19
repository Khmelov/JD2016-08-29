package by.it.tsydzik.jd01_05;

import static java.lang.Math.*;

/**
 * Created by user on 12.09.2016.
 */
public class Task4 {
    public static void compute() {
        double del = 0.2;
        double k = 1;
        for (int i = 2; i <= 8; i++) {
            for (double a = 0; a <= 2; a += del) {
                k = k * pow(E, i) - 2.11 * a;
                System.out.println(k);
            }
        }
    }
}
