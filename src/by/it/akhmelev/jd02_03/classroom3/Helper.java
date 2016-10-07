package by.it.akhmelev.jd02_03.classroom3;

/**
 * Created by user on 03.10.2016.
 */
public class Helper {
    protected static int rnd(int from, int to){
        return from+(int)(Math.round(Math.random()*(to-from)));
    }

    protected static int rnd(int max){
        return rnd(0,max);
    }

    protected static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
