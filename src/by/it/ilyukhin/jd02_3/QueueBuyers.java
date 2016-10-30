package by.it.ilyukhin.jd02_3;

import java.util.ArrayDeque;

public class QueueBuyers {
    static final Integer monitorQueueBuyers=0;
    private static ArrayDeque<Buyer> queue=new ArrayDeque<>();

    public static int getSize(){
        int res;
        synchronized (monitorQueueBuyers) {
            res=queue.size();
        }
        return res;
    }
    public static void add(Buyer b){
        queue.addLast(b);
        if (Dispatcher.needCashiers()){
            Dispatcher.poolCashier.execute(new Cashier());
        }
    }
    static Buyer extract() {
        Buyer b;
        synchronized (monitorQueueBuyers) {
            b = queue.pollFirst();
        }
        return b;
    }

    static boolean needService() {
        boolean needService;
        synchronized (monitorQueueBuyers) {
            needService = (queue.size() > 0);
        }
        return needService;
    }


}
