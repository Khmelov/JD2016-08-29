package by.it.emelyanov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner {
    public static void main(String[ ] args) {

        ExecutorService executor=Executors.newFixedThreadPool(5);
        executor.execute(new Cashier());
        executor.execute(new Cashier());
        while (!Dispatcher.planComplete()) {
            Helper.sleep(1000);
            int count= Helper.fromTo(0, 2);
            for (int i = 0; i <= count; i++) {
                 new Buyer();
                 if (Dispatcher.planComplete())
                     break;
            }
        }

        executor.shutdown();

    }
}
