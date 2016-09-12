package by.it.opashniuk.jd01_05.math;
import static java.lang.Math.*;

public class Task3 {
    public static void tabul(){
        for (double t=2; t<=3; t=t+0.1) {
            double s=log(1.3+t)-pow(E,t);
            System.out.println("t="+t+"; s="+s+";");

        }
    }
}
