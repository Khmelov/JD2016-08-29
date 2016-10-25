package by.it.grishechkin.jd02_01;

/**
 * Created by Yury on 03.10.2016.
 */
public class Helper {
    public static int rnd(int from, int to) {
        int i = from + (int)Math.round(Math.random()*(to - from));
        return i;
    }

    public static int rnd(int to) {
        int i = rnd(0, to);
        return i;
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
