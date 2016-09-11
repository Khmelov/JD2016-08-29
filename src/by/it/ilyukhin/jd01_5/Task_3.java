package by.it.ilyukhin.jd01_5;


public class Task_3 {
        public static void printTable(){

            double x = 3.567;

            System.out.println("┏━━━━━━━┳━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃ param ┃        value       ┃");
            System.out.println("┣━━━━━━━╋━━━━━━━━━━━━━━━━━━━━┫");
            for (double a = -5; a <= 12; a += 2.5){
                double y = (1.0 / Math.tan(Math.pow(x, 3))) + 2.24 * a * x;
                System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s", "┃", a, "┃", y, "┃"));
            }
            System.out.println("┗━━━━━━━┻━━━━━━━━━━━━━━━━━━━━┛");
        }
    }

