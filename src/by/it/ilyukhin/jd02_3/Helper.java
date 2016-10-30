package by.it.ilyukhin.jd02_3;

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
