package by.it.vashukevich.jd02_03;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Dispatcher.poolCashiers.execute(new Cashier());
        while (Dispatcher.countBuyers.get()<Dispatcher.PLAN_COUNT_BUYERS) {
            int cuont = Help.fromTo(20);
            for (int i = 0; i <cuont; i++) {
                Buyer buyer = new Buyer(Dispatcher.countBuyers.incrementAndGet());
                Thread b1 = new Thread(buyer);
                b1.start();
                if (Dispatcher.countBuyers.get() == Dispatcher.PLAN_COUNT_BUYERS)
                    break;
            }
                Help.sleep(1000);
            }
        while (!Dispatcher.isFinished())
            Help.sleep(100);
            Dispatcher.poolCashiers.shutdown();
    }
}
