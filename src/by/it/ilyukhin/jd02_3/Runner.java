package by.it.ilyukhin.jd02_3;


public class Runner {
    public static void main(String[] args) {
        Dispatcher.poolCashier.execute(new Cashier());
        while (Dispatcher.countBuyers.get()<Dispatcher.PLAN_COUNT_BUYERS) {
            int n= Helper.rnd(10);
            for (int i = 0; i < n; i++) {

                Buyer buyer=new Buyer(
                        Dispatcher.countBuyers.incrementAndGet()
                );
                Thread th=new Thread(buyer);
                th.start();
                if (Dispatcher.countBuyers.get()==Dispatcher.PLAN_COUNT_BUYERS)
                    break;
            }
            Helper.sleep(1000);
        }
        while (!Dispatcher.isFinished())
            Helper.sleep(100);
        Dispatcher.poolCashier.shutdown();
    }
}
