package by.it.grishechkin.jd01_13;

/**
 * Created by Yury on 21.10.2016.
 */
public class Runner {
    public static void main(String[] args) {

        try {
            TaskB.oneDiv(2,1); // Здесь передается а и b. Если б = 0, то деление на ноль, если а < 0, то корень из отрицательного числа
        }
        catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }

        TaskA.readAndPrint();
    }
}
