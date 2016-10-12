package by.it.rudzko.jd_02_03;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Olga Rudzko
 */
public class QueueBuyers {

    private static ConcurrentLinkedQueue<Buyer> queue = new ConcurrentLinkedQueue<>();

    public static int getSize() {
        return queue.size();
    }

    static void addBuyer(Buyer x) {
        queue.add(x);
        Cashier.poolCashiers.execute(new Cashier());
        System.out.println("New Cahsier opened.");
    }

    static Buyer serve() {
        return queue.poll();
    }

    static boolean notEmpty() {
        return !queue.isEmpty();
    }
}
