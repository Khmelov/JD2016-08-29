package by.it.yarosh.jd01_05.math;
import static java.lang.Math.*;
/**
 * Created by Ил on 13.09.2016.
 */

public class Task3 {
    public static void functab(){
        double x = 3.567;
        System.out.println("┏━━━━━━━┳━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ param ┃        value       ┃");
        System.out.println("┣━━━━━━━╋━━━━━━━━━━━━━━━━━━━━┫");
        for (double a = -5; a <= 12; a += 2.5) {
            double y = (1 / tan(pow(x, 3))) + 2.24 * a * x;
            System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s", "┃", a, "┃", y, "┃"));
        }
        System.out.println("┗━━━━━━━┻━━━━━━━━━━━━━━━━━━━━┛");


    }
}
