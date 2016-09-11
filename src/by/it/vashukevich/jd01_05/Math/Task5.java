package by.it.vashukevich.jd01_05.Math;

import static java.lang.Math.*;
/**
 * Created by Admin on 11.09.16.
 */
public class Task5 {
    static public void task5() {
        double b;
        for (double x = -6; x < 2; x += 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = pow(sin(x), 2);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = pow(cos(x), 2);
            } else if (x == 0.2) {
                b = pow((1 / tan(x)), 2);
            } else {
                continue;
            }
            double a = log(b + 2.74);
            System.out.println(String.format("%1s%25s", x, a));
        }
    }
}
