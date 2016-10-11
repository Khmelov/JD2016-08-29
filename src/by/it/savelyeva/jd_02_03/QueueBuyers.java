package by.it.savelyeva.jd_02_03;

/**
 * Created by nato on 10/5/16.
 */

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Queue of buyers
 */
public class QueueBuyers {

    private static PriorityBlockingQueue<Buyer> queue = new PriorityBlockingQueue<>(
            40, new Comparator<Buyer>() {
                @Override
                public int compare(Buyer b1, Buyer b2) {
                    if (b1.isPensioner()) return -1;
                    else return 1;
                }
            }
        );

    public static int getSize() {
        return queue.size();
    }

    public static boolean addBuyer(Buyer buyer) {
        boolean res = queue.add(buyer);
        if (Market.needCashiers()) {
            Market.poolCashiers.execute(new Cashier());
        }
        return res;
    }

    public static Buyer poll() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    public static boolean needService() {
            return !queue.isEmpty();
        }

    public static void print() {
        for (Object buyer: queue.toArray()) {
            System.out.printf("%s; ", buyer);
        }
        System.out.println();
    }
}
