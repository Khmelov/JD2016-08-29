package by.it.laurynovich.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by vseotdala on 11.09.2016.
 */
public class Task_3 {
    public static double Math03() {
        double x = 12.1;
        double l = 0;
        for (double c = -10; c <= 1; c += 0.5) {
            l = pow( 2*x - c, 0.6) + 0.567;
            System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s", "┃", c, "┃", l, "┃"));
        }
        return l;
    }

}


