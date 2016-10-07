package by.it.tsydzik.jd02_01;

import java.util.ArrayDeque;

/**
 * @author Eugene Tsydzik
 * @since 10/05/16.
 */
public class QueueBuyer {
    public static final Integer monitorQueueBuyer = 0;

    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    public static void add(Buyer buyer) {
        queue.addLast(buyer);
        if (Dispatcher.countCashier < 5) {
            synchronized (Dispatcher.monitorCountCashier) {
                new Thread(new Cashier()).start();
                Dispatcher.countCashier++;
            }
        }
    }

    static Buyer extract() {
        Buyer b;
        synchronized (monitorQueueBuyer) {
            b = queue.pollFirst();
        }
        return b;
    }

    static boolean needService() {
        boolean needService;
        synchronized (monitorQueueBuyer) {
            needService =! queue.isEmpty();
        }
        return needService;
    }

}
