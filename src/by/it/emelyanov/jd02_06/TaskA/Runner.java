package by.it.emelyanov.jd02_06.TaskA;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getMyLoger();

        try {
            int a = (int) (Math.random() * 2) - 1;
            System.out.println("a = " + a);
            try {
                int b = 1 / a;
                StringBuilder stringBuilder = new StringBuilder(a);
            } catch (NegativeArraySizeException e) {
                System.err.println("Недопустимый размер буфера: " + e);
                logger.writeInLog("Недопустимый размер буфера: ", e);
            }
        } catch (ArithmeticException e) {
            System.err.println("Деление на 0: " + e);
            logger.writeInLog("Деление на 0: ", e);
        }
    }
}

