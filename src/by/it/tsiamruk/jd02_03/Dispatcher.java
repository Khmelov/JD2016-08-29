package by.it.tsiamruk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 05.10.2016.
 */
public class Dispatcher {
    static int countCashiers = 0;
    private static final int planCount = 40;
    static int countBuyers = 0;
    static int countCompleteBuyers = 0;
    static AtomicInteger completeBuyersCount = new AtomicInteger(0);

    static boolean planComplete() {
        return countBuyers >= planCount;
    }

    static boolean finish() {
        return countCompleteBuyers >= planCount;
    }
}
