package by.it.tsiamruk.jd02_02;

/**
 * Created by waldemar on 05/10/2016.
 */
public class Cashier implements Runnable {
    @Override
    public void run() {
        while (QueueBuyers.needService()) {
            Buyer b = QueueBuyers.extract();
            System.out.println("Start service:" + b);
            Helper.sleep(Helper.rnd(1000));
            System.out.println("Billing...:" + b);
            System.out.println("Stop service: " + b);
            synchronized (b) {
                b.notify();
            }
        }
        System.out.println("Cashier stop");
        synchronized (Dispatcher.monitorCountCashiers) {
            Dispatcher.countCashiers--;
        }
    }
}
