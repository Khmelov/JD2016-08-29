package by.it.grishechkin.jd01_05;


import static java.lang.Math.*;

/**
 * Created by Yury on 19.09.2016.
 */
public class Task3 {

    public static void tabulate(double t1, double t2, double dt) {
        double buff = t1;
        System.out.println("\ttd\t  rez");
        do {
            System.out.printf("%1$+5.3f \t%2$+5.3f", buff, calc(buff));
            System.out.println();
            buff += dt;
        }
        while (buff <= t2);
    }

    public static double calc(double t) {
        return log(abs(1.3 + t)) - pow(exp(1),t);
    }
}
