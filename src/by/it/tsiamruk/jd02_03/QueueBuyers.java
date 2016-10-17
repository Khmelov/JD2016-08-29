package by.it.tsiamruk.jd02_03;

import java.util.concurrent.ConcurrentLinkedDeque;

class QueueBuyers {

    protected static ConcurrentLinkedDeque<Buyer> queue = new ConcurrentLinkedDeque<>();

    public static void add(Buyer b) {
        if (queue.size() < 40)
            if (b.isPensioner())
                queue.addFirst(b);
            else
                queue.add(b);
    }

    static Buyer pool() {
        if (queue.isEmpty())
            return null;
        else
            return queue.pollFirst();
    }

    protected static boolean needService() {
        return !queue.isEmpty();
    }
}
