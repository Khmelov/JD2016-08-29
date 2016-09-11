package by.it.ilyukhin.jd01_5;


public class Task_4 {
    public static double calculate() {
           double sum = 0;

            for (double e = 2; e <= 8; e++) {
                 for (double a = 0; a <= 2; a = a + 0.2) {
                    double k = Math.pow(e,2) - 2.11 * a;
                    sum += k;
                }

            }
            return sum;
        }
    }


