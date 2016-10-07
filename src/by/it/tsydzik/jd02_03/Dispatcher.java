package by.it.tsydzik.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Eugene Tsydzik
 * @since 10/05/16.
 */
public class Dispatcher {
    //на случай синхронного увеличения
    static ExecutorService poolCashier = Executors.newFixedThreadPool(5);

    static AtomicInteger countCashier = new AtomicInteger(0);

    static AtomicInteger countBuyers = new AtomicInteger(0);
    static AtomicInteger countOutBuyers = new AtomicInteger(0);
    final static int PLAN_COUNT_BUYERS = 10;

    static boolean isFinised() {
        return (countOutBuyers.get() >= PLAN_COUNT_BUYERS);
    }

    static boolean needCashier() {

        boolean res = countCashier.get() * 5 < QueueBuyer.getSize();
        if (!res && countCashier.get() == 1) {
            res = !Dispatcher.isFinised();
        }
        if (countCashier.get() >= 5 && res) {
            res = false;
        }
        return res;
    }
}
