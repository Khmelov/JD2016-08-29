package by.it.tsiamruk.jd02_03;

import java.util.ArrayDeque;

class QueueBuyers {
    static final Integer monitorQueueBuyers = 0;
    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    public static int getSize() {
        int res;
        synchronized (monitorQueueBuyers) {
            res = queue.size();
        }
        return res;
    }

    public static void add(Buyer b) {
        queue.addLast(b);
        if (Dispatcher.needCashiers()) {
            //так не падает
            //new Thread(new Cashier()).start();

            //так тоже не падает, см. Dispatcher.needCashiers
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
            needService = !queue.isEmpty();
        }
        return needService;
    }
}
