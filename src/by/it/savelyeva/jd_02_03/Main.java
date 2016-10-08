package by.it.savelyeva.jd_02_03;

/**
 * Created by nato on 10/3/16.
 */
public class Main {
    public static void runNatural() {
        long t1 = System.currentTimeMillis();
        double t = 0; // seconds passed within each minute
        while (!Market.isPlanCompleted()) {
            int max = 0;
            int buyersInside = Market.countBuyers.get() - Market.countBuyersOut.get();
            if (Math.round(t) % 60 < 30) max = 2;
            else if (buyersInside <= 40 + (30 - t)) max = 2;
            for (int i = 0; i < Helper.rnd(max); i++) {
                Buyer buyer = new Buyer(Market.countBuyers.incrementAndGet());
                buyer.start();
                if (Market.isPlanCompleted()) {
                    break;
                }
            }
            Helper.sleep(1000);
            if (t > 60) t1 = System.currentTimeMillis();
            t = (System.currentTimeMillis() - t1) / 1000;
        }
        //Market.print();
        Market.shutdownCashiersPool();
    }

    public static void runSimple() {
        while (!Market.isPlanCompleted()) {
            for (int i=0; i<Helper.rnd(2); i++) {
                Buyer buyer = new Buyer(Market.countBuyers.incrementAndGet());
                buyer.start();
                if (Market.isPlanCompleted()) {
                    break;
                }
            }
            Helper.sleep(1000);
        }
        //Market.print();
        Market.shutdownCashiersPool();
    }

    public static void main(String[] args) {
        //runSimple();
        runNatural();
    }

}