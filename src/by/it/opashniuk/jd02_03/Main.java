package by.it.opashniuk.jd02_03;

public class Main {
    public static void main(String[] args) {

        Dispetcher.poolCashiers.execute(new Cashier());
        while (Dispetcher.countBuyers.get()<Dispetcher.PLAN_COUNT_BUYERS) {
            int n= Helper.rnd(20);
            for (int i = 0; i < n; i++) {

                Buyer buyer=new Buyer(
                        Dispetcher.countBuyers.incrementAndGet()
                );
                Thread th=new Thread(buyer);
                th.start();
                if (Dispetcher.countBuyers.get()==Dispetcher.PLAN_COUNT_BUYERS)
                    break;
            }
            Helper.sleep(1000);
        }
        while (!Dispetcher.isFinished())
            Helper.sleep(100);
        Dispetcher.poolCashiers.shutdown();
    }
}
