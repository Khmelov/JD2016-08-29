package by.it.tsydzik.jd02_03;

/**
 * @author Eugene Tsydzik
 * @since 10/03/16.
 */
public class Main {
    public static void main(String[] args) {

        Dispatcher.poolCashier.execute(new Cashier());

        while (Dispatcher.countBuyers.get() < Dispatcher.PLAN_COUNT_BUYERS) {
            int n = Helper.rnd(2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(Dispatcher.countBuyers.incrementAndGet());
                Thread th = new Thread(buyer);
                th.start();
                if (Dispatcher.countBuyers.get() == Dispatcher.PLAN_COUNT_BUYERS) {
                    break;
                }
            }
            Helper.sleep(1000);
        }
        Dispatcher.poolCashier.shutdown();
    }
}
