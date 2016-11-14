package by.it.laurynovich.jd02_06;

public class Main {

    public static void main(String[] args) {
        SingletonLogger logger = SingletonLogger.getInstance();
        for (int i=0; i<10; i++) {
            try {
                int n = (int) Math.round(Math.random());
                System.out.printf("%d/%d = %d\n", i, n, i/n);
            } catch (ArithmeticException e) {
                logger.log("деление на ноль!");
            }
        }

    }

}