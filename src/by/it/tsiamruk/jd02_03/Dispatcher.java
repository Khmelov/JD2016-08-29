package by.it.tsiamruk.jd02_03;

/**
 * Created by user on 05.10.2016.
 */
public class Dispatcher {
    static final Integer monitorCountCashies = 0;
    static int countCashiers = 0;
    private static final int planCount = 100;
    static int countBuyers = 0;
    static int countCompleteBuyers = 0;

    static boolean planComplete() {
        return countBuyers >= planCount;
    }

    static boolean finish() {
        return countCompleteBuyers >= planCount;
    }

    //just for minimize code in other Objects
    static void sleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
