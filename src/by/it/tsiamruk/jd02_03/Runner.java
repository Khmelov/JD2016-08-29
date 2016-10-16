package by.it.tsiamruk.jd02_03;

public class Runner {
    public static void main(String[] args) {


        while (!Dispatcher.planComplete()) {
            Dispatcher.needCashiers();
            Helper.sleep(1000);
            int n = Helper.rnd(2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(Dispatcher.countBuyers.incrementAndGet());
                Thread th = new Thread(buyer);
                th.start();
                if (Dispatcher.planComplete())
                    break;
            }
        }
        Cashier.executor.shutdown();
    }
}
