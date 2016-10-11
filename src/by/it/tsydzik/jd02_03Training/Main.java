package by.it.tsydzik.jd02_03Training;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Main {
    public static void main(String[] args) {

        Dispatcher.poolCashier.execute(new Cashier());
        Dispatcher.poolCashier.execute(new Cashier());
        Dispatcher.poolCashier.execute(new Cashier());
        Dispatcher.poolCashier.execute(new Cashier());
        Dispatcher.poolCashier.execute(new Cashier());

        while (!Dispatcher.planComplete()) {
            Helper.sleep(1000);
            int count= Helper.rnd(0, 2);    // то количество покупателей,
                                            // которое может пройти: 0 1 2
            for (int i = 0; i <= count; i++) {
                Buyer buyer = new Buyer(Dispatcher.countBuyers.incrementAndGet());
                Thread th = new Thread(buyer);
                th.start();
                if (Dispatcher.planComplete())
                    break;
            }
        }
        //завершениe сервиса касс (нельзя будет добавить новые)
        //однако сами кассы продолжают работу, т.к. они уже выполняются
        Dispatcher.poolCashier.shutdown();
    }

}
