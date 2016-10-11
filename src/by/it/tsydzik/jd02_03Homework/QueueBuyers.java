package by.it.tsydzik.jd02_03Homework;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class QueueBuyers {

    //экземпляр очереди
    private final static ConcurrentLinkedQueue queueBuyers = new ConcurrentLinkedQueue();

    public static int getSize() {
        return queueBuyers.size();
    }

    public static boolean add(Buyer buyer) {
        boolean res = queueBuyers.add(buyer);
        if (Dispatcher.needCashiers()) {
            Dispatcher.poolCashiers.execute(new Cashier());
        }
        return res;
    }

    public static Buyer poll() {
        if (queueBuyers.isEmpty()) {
            return null;
        } else {
            return (Buyer) queueBuyers.poll();
        }
    }

    public static boolean needService() {
        return !queueBuyers.isEmpty();
    }
}
