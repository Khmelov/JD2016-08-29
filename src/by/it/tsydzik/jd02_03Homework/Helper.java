package by.it.tsydzik.jd02_03Homework;

/**
 * @author Eugene Tsydzik
 * @since 10/11/16.
 */
public class Helper {
    public static int rnd(int from, int to) {
        return from + (int) (Math.round(Math.random() * (to - from)));
    }

    public static int rnd(int max) {
        return rnd(0, max);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
