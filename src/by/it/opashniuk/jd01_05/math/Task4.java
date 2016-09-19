package by.it.opashniuk.jd01_05.math;
import static java.lang.Math.*;

public class Task4 {
    public static double cikl() {
        double sum=0;
        for (double t = 2; t < 3; t=t+0.1) {
            for (double d = 23; d <= 39; d++) {
                double m=log(abs(d-t));
                sum=sum+m;
            }
        }
        return sum;
    }
}
