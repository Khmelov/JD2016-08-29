package by.it.grishechkin.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Yury on 06.11.2016.
 */

public class BuyerQueue {

    public static ConcurrentLinkedQueue buyersQueue = new ConcurrentLinkedQueue();

    public static boolean add(Buyer buyer) {
        return buyersQueue.add(buyer);
    }

    public static Buyer poll() {
        if (buyersQueue.isEmpty())
            return null;
        else
            return (Buyer) buyersQueue.poll();
    }
}
