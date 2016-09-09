package by.it.tsiamruk.jd01_05.math;

import static java.lang.Math.*;

public class Task3 {
    public static void functionTabulation(){

        final double rangeStart = 3.5;
        final double rangeEnd = 25.5;

        double x = 3.567;

        System.out.println("______________________________");
        System.out.println("| param |        value       |");
        System.out.println("______________________________");

        for (double a = rangeStart; a <= rangeEnd; a +=3.75){
            double y = 1 / tan(pow(x, 3)) + 2.24 * a * x;
            System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s", "|", a, "|", y, "|"));
        }

        System.out.println("|       |                    |");
        System.out.println("------------------------------");

    }
}
