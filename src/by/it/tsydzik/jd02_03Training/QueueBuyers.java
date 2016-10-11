package by.it.tsydzik.jd02_03Training;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class QueueBuyers {

    //экземпляр очереди
    private final static ConcurrentLinkedQueue queueBuyers = new ConcurrentLinkedQueue();

    public static boolean add(Buyer buyer) {
        return queueBuyers.add(buyer);
    }

    public static Buyer poll() {
        if (queueBuyers.isEmpty()) {
            return null;
        } else {
            return (Buyer) queueBuyers.poll();
        }
    }
}
