package by.it.tsydzik.jd02_03;

/**
 * @author Eugene Tsydzik
 * @since 10/05/16.
 */
public class Cashier implements Runnable{

    @Override
    public void run() {
        while (QueueBuyer.needService()){
            Buyer buyer = QueueBuyer.extract();
            System.out.println("Start service " + buyer);
            Helper.sleep(Helper.rnd(1000));
            System.out.println("Billing " + buyer);
            System.out.println("Stop service " + buyer);
            synchronized (buyer){
                buyer.notify();
            }
        }

        synchronized (Dispatcher.monitorCountCashier){
            Dispatcher.countCashier--;
        }

        System.out.println("-------->>>>>>>>>>>>>> STOP");
    }
}
