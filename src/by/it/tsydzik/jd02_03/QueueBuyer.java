package by.it.tsydzik.jd02_03;

import java.util.ArrayDeque;

/**
 * @author Eugene Tsydzik
 * @since 10/05/16.
 */
public class QueueBuyer {
    public static final Integer monitorQueueBuyer = 0;

    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    public static int getSize() {
        int res = 0;
        synchronized (monitorQueueBuyer) {
            res = queue.size();
        }
        return res;
    }

    public static void add(Buyer buyer) {
        queue.addLast(buyer);
        if (Dispatcher.needCashier()) {
            new Thread(new Cashier()).start();
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
            needService = !queue.isEmpty();
        }
        return needService;
    }

}
