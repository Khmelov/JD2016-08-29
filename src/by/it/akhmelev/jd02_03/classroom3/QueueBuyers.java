package by.it.akhmelev.jd02_03.classroom3;

import java.util.ArrayDeque;

class QueueBuyers {
    static final Integer monitorQueueBuyers = 0;
    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    public static void add(Buyer b) {
        queue.addLast(b);
        if (Dispatcher.countCashiers.get() * 2 < queue.size()
            && Dispatcher.countCashiers.get() < 5) {
            //так не падает
            new Thread(new Cashier()).start();

            //так падает
            //Dispatcher.poolCashiers.execute(new Cashier());
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
