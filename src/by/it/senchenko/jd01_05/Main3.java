package by.it.senchenko.jd01_05;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Main3 {
    public static void main(String[] args){
        double x=3.67;
        System.out.println("┏━━━━━━━┳━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ param ┃        value       ┃");
        System.out.println("┣━━━━━━━╋━━━━━━━━━━━━━━━━━━━━┫");
        for (double c = -10; c <= 1; c += 1.25){
            double y = pow(abs(2*x-c),(1/5))+0.567;
            System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s", "┃", c, "┃", y, "┃"));
        }
        System.out.println("┗━━━━━━━┻━━━━━━━━━━━━━━━━━━━━┛");
    }
}
