package by.it.tsiamruk.jd02_02;

import java.util.ArrayDeque;

/**
 * Created by waldemar on 05/10/2016.
 */

class QueueBuyers {

    static final Integer monitorQueueBuyers = 0;
    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    public static void add(Buyer b) {
        queue.addLast(b);
        if (Dispatcher.countCashiers < 5) {
            synchronized (Dispatcher.monitorCountCashiers) {
                new Thread(new Cashier()).start();
                Dispatcher.countCashiers++;
            }
        }
    }

    static Buyer extract() {
        Buyer b;
        synchronized (monitorQueueBuyers) {
            b = queue.pollFirst();
        }
        return b;
    }

    static boolean needService() {
        boolean needService;
        synchronized (monitorQueueBuyers) {
            needService = !queue.isEmpty();
        }
        return needService;
    }
}
