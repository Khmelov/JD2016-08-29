package by.it.tsiamruk.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (!Dispatcher.planComplete()) {
            Helper.sleep(1000);
            int n = Helper.rnd(2);
            for (int i = 0; i < n; i++) {
                Buyer buyer = new Buyer(++Dispatcher.countBuyers);
                Thread th = new Thread(buyer);
                th.start();
                if (Dispatcher.planComplete())
                    break;
            }
        }
        executor.shutdown();
    }
}
