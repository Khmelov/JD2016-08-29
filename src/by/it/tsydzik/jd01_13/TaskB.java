package by.it.tsydzik.jd01_13;

/**
 * @author Eugene Tsydzik
 * @since 09/26/16.
 */
public class TaskB {

    static void level1() throws Exception {
        System.out.println("Start level 1");
        level2();
        System.out.println("Stop level 1");
        throw new Exception("Наша ошибка");
    }

    static void level2() throws ArrayIndexOutOfBoundsException {
        System.out.println("Start level 2");
        level3();
        System.out.println("Stop level 2");
    }

    static void level3() throws ArrayIndexOutOfBoundsException {
        System.out.println("Start level 3");
        int[] mas = {1, 10};
        int i = (int) Math.round(Math.random() * 3);
        try {
            int j = 10 / i;
            int k = mas[i] / 10;
            System.out.println("I =" + i + " J =" + j + " K =" + k);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
        System.out.println("Stop level 3");
    }
}
