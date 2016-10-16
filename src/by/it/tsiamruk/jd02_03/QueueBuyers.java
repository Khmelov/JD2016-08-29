package by.it.tsiamruk.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;

class QueueBuyers {

    protected static ConcurrentLinkedQueue<Buyer> queue = new ConcurrentLinkedQueue<>();

    public static void add(Buyer b) {
        queue.add(b);

    }

    static Buyer pool() {
        if (queue.isEmpty())
            return null;
        else
            return queue.poll();
    }

    protected static boolean needService() {
        return !queue.isEmpty();
    }
}
