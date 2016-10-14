package by.it.tsiamruk.jd02_03;

import java.util.concurrent.ConcurrentLinkedDeque;

class QueueBuyers {
    private static ConcurrentLinkedDeque<Buyer> queue = new ConcurrentLinkedDeque<>();

    public static void add(Buyer b) {
        if (b.isPensioner())
            queue.addFirst(b);
        else
            queue.add(b);
        if (Dispatcher.countCashiers < 5) {
            new Thread(new Cashier()).start();
            Dispatcher.countCashiers++;
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
            needService = !queue.isEmpty();
        return needService;
    }
}
