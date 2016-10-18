package by.it.savelyeva.jd_02_06;

/**
 * Created by nato on 10/15/16.
 */

public class Main {

    public static void main(String[] args) {
        SingletonLogger logger = SingletonLogger.getInstance();
        for (int i=0; i<20; i++) {
            try {
                int n = (int) Math.round(Math.random());
                System.out.printf("%d/%d = %d\n", i, n, i/n);
            } catch (ArithmeticException e) {
                logger.log("Division by zero!");
            }
        }

    }

}