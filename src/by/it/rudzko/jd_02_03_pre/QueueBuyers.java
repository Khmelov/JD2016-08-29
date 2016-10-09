package by.it.rudzko.jd_02_03_pre;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Olga Rudzko
 */
public class QueueBuyers {

    private static ConcurrentLinkedQueue<Buyer> queue = new ConcurrentLinkedQueue<Buyer>();

    public static int getSize() {
        return queue.size();
    }

    public static void addBuyer(Buyer x) {
        queue.add(x);
        Cashier.poolCashiers.execute(new Cashier());
        System.out.println("New Cahsier opened.");
    }

    public static Buyer serve() {
        return queue.poll();
    }

    public static boolean notEmpty() {
        return !queue.isEmpty();
    }
}
