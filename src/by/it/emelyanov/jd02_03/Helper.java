package by.it.emelyanov.jd02_03;

import java.util.Random;

class Helper {
    static final long init=System.currentTimeMillis();
    static final Random random = new Random(init);

    static int fromTo(int from, int to) {
        int delta=to-from+1;
        int msWait=from+random.nextInt(delta);
        return msWait;
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
