package by.it.artiuschik.jd_02_03;
import java.util.concurrent.ConcurrentLinkedQueue;

class QueueBuyers {
    static final Integer monitorQueueBuyers = 0;
    private static ConcurrentLinkedQueue<Buyer> buyers = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<Buyer> pensioneers = new ConcurrentLinkedQueue<>();

    static ConcurrentLinkedQueue<Buyer> getBuyers() {
        return buyers;
    }

    static ConcurrentLinkedQueue<Buyer> getPensioneers() {
        return pensioneers;
    }

    public static void add(Buyer b) {
            if (!b.isPensioneer()) {
                buyers.add(b);
            } else {
                pensioneers.add(b);
            }

            if ((Dispatcher.countCashiers.get() * 5 < (buyers.size() + pensioneers.size())) && (Dispatcher.numberOfCashier.get() < 5)) {
                synchronized (Dispatcher.monitorForSystemOut) {
                    System.out.println("cashiers=" + Dispatcher.countCashiers.get() + " queue size=" + (buyers.size() + pensioneers.size()));
                }
                    Dispatcher.poolCashiers.execute(new Cashier());
            }


    }

    static Buyer extract() {
            if (!pensioneers.isEmpty()) {
                return pensioneers.poll();
            } else {
                return buyers.poll();
            }
    }

    static boolean needService() {
        boolean needService;
        synchronized (monitorQueueBuyers) {
        needService =!(buyers.isEmpty()&&pensioneers.isEmpty());
        }
        return needService;
    }
}
