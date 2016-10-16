package by.it.tsiamruk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;


public class Dispatcher {
    static AtomicInteger countCashiers = new AtomicInteger(0);
    private static final int PLAN_COUNT = 100;
    static AtomicInteger countBuyers = new AtomicInteger(0);
    static double[] amount = new double[5];
    static AtomicInteger completeBuyersCount = new AtomicInteger(0);

    static boolean planComplete() {
        return countBuyers.get() >= PLAN_COUNT;
    }

    static boolean finish() {
        return completeBuyersCount.get() >= PLAN_COUNT;
    }

    static void needCashiers() {
        if (QueueBuyers.needService() && countCashiers.get() != 5)
            Cashier.executor.execute(new Cashier());
    }


}
