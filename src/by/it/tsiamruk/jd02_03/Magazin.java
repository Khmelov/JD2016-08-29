package by.it.tsiamruk.jd02_03;

public class Magazin {
    public static void main(String[] args) {

        Dispatcher.poolCashiers.execute(new Cashier());
        while (Dispatcher.countBuyers.get() < Dispatcher.PLAN_COUNT_BUYERS) {
            int n = Helper.rnd(2);
            n = 100;
            for (int i = 0; i < n; i++) {

                Buyer buyer = new Buyer(
                        Dispatcher.countBuyers.incrementAndGet()
                );
                Thread th = new Thread(buyer);
                th.start();
                if (Dispatcher.countBuyers.get() == Dispatcher.PLAN_COUNT_BUYERS)
                    break;
            }
            Helper.sleep(1000);
        }
        Dispatcher.poolCashiers.shutdown();
    }
}
