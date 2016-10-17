package by.it.tsiamruk.jd02_03;

public class Runner {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        double t = 0;
        while (!Dispatcher.planComplete()) {
            Dispatcher.needCashiers();
            int max = 0;
            int buyersInside = Dispatcher.countBuyers.get() - Dispatcher.completeBuyersCount.get();
            if (Math.round(t) % 60 < 30) max = 2;
            else if (buyersInside <= 40 + (30 - t)) max = 2;
            for (int i = 0; i < Helper.rnd(max); i++) {
                Buyer buyer = new Buyer(Dispatcher.countBuyers.incrementAndGet());
                Thread th = new Thread(buyer);
                th.start();
                if (Dispatcher.planComplete())
                    break;
            }
            Helper.sleep(1000);
            if (t > 60) t1 = System.currentTimeMillis();
            t = (System.currentTimeMillis() - t1) / 1000;
        }
        Cashier.executor.shutdown();
    }
}
