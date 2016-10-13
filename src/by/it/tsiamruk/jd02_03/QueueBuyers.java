package by.it.tsiamruk.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;

class QueueBuyers {
    static final Integer monitorQueueBuyers = 0;
    private static ConcurrentLinkedQueue<Buyer> queue = new ConcurrentLinkedQueue<>();

    public static void add(Buyer b) {
        queue.add(b);
        if (Dispatcher.countCashiers < 5) {
            synchronized (Dispatcher.monitorCountCashies) {
                new Thread(new Cashier()).start();
                Dispatcher.countCashiers++;
            }
        }
    }

    static Buyer pool() {
        if (queue.isEmpty())
            return null;
        else
            return queue.poll();
    }


    static boolean needService() {
        boolean needService;
        synchronized (monitorQueueBuyers) {
            needService = !queue.isEmpty();
        }
        return needService;
    }
}
