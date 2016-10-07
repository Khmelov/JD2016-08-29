package by.it.akhmelev.jd02_03.classroom3;

import by.it.akhmelev.jd02_02.classroom2.*;
import by.it.akhmelev.jd02_02.classroom2.Cashier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {

        Dispatcher.poolCashiers.execute(new Cashier());
        Dispatcher.poolCashiers.execute(new Cashier());
        Dispatcher.poolCashiers.execute(new Cashier());
        Dispatcher.poolCashiers.execute(new Cashier());
        Dispatcher.poolCashiers.execute(new Cashier());
        while (Dispatcher.countBuyers.get()<Dispatcher.PLAN_COUNT_BUYERS) {
            int n= Helper.rnd(2);
            n=100;
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
        Dispatcher.poolCashiers.shutdown();
    }
}
