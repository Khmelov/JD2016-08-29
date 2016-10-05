package by.it.akhmelev.jd02_02.classroom2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class QueueBuyers {
    static final Integer monitorQueueBuyers = 0;
    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    public static void add(Buyer b) {
        queue.addLast(b);
        if (Dispatcher.countCashiers < 5) {
            synchronized (Dispatcher.monitorCountCashies) {
                new Thread(new Cashier()).start();
                Dispatcher.countCashiers++;
            }
        }
    }

     static Buyer extract() {
        Buyer b;
        synchronized (monitorQueueBuyers) {
            b=queue.pollFirst();
        }
        return  b;
    }

    static boolean needService() {
        boolean needService;
        synchronized (monitorQueueBuyers) {
            needService=!queue.isEmpty();
        }
        return needService;
    }
}
