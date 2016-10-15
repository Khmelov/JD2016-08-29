package by.it.tsiamruk.jd02_03;

class QueueBuyers {

    public static void add(Buyer b) {
        Buyer.queue.add(b);

    }

    static Buyer pool() {
        if (Buyer.queue.isEmpty())
            return null;
        else
            return Buyer.queue.poll();
    }
}
