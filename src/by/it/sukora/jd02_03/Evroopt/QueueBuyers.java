package by.it.sukora.jd02_03.Evroopt;


import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

class QueueBuyers {
    static final Integer monitorQueueBuyers = 0;
    private static ArrayDeque<Buyer> queue1 = new ArrayDeque<>();

    private static PriorityBlockingQueue<Buyer> queue = new PriorityBlockingQueue<>(
            40, new Comparator<Buyer>() {
        @Override
        public int compare(Buyer b1, Buyer b2) {
            if (b1.isPensioner()) return -1;
            else return 1;
        }
    }
    );

    public static int getSize() {
        int res;
        synchronized (monitorQueueBuyers) {
            res = queue1.size();
        }
        return res;
    }

    public static void add(Buyer b) {
        queue1.addLast(b);
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
            b = queue1.pollFirst();
        }
        return b;
    }

    static boolean needService() {
        boolean needService;
        synchronized (monitorQueueBuyers) {
            needService = (queue1.size() > 0);
        }
        return needService;
    }
}