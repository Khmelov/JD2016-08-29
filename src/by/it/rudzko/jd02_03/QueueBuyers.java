package by.it.rudzko.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Olga Rudzko
 */
public class QueueBuyers {

    private static ConcurrentLinkedQueue<Buyer> queue = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<Buyer> quePens = new ConcurrentLinkedQueue<>();

    public static int getSize() {
        return queue.size() + quePens.size();
    }

    static void addBuyer(Buyer x) {
        if (!x.getPensioner())
            queue.add(x);
        else quePens.add(x);
        Cashier.poolCashiers.execute(new Cashier());
    }

    static Buyer serve() {
        return (quePens.isEmpty()) ? queue.poll() : quePens.poll();
    }

    static boolean notEmpty() {
        return !queue.isEmpty() || !quePens.isEmpty();
    }
}
