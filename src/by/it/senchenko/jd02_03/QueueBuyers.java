package by.it.senchenko.jd02_03;

import java.util.ArrayDeque;

class QueueBuyers {
    static final Integer monitorQueueBuyers = 0;
    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    public static int getSize(){
        int res;
        synchronized (monitorQueueBuyers) {
            res = queue.size();
        }
        return res;
    }

    public static void add(Buyer b) {
        queue.addLast(b);
        if (Dispatcher.needCashiers()) {
            Dispatcher.poolCashiers.execute(new Cashier());
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
            needService = (queue.size() > 0);
        }
        return needService;
    }
}
