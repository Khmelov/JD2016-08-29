package by.it.sukora.jd02_01.Evroopt;


public class Helper {
    protected static int rnd(int from, int to) {
        int i = from + (int) (Math.round(Math.random() * (to - from)));
        return i;
    }

    protected static int rnd(int max) {
        return rnd(0, max);
    }

    protected static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
