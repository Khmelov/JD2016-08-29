package by.it.tsydzik.jd02_03;

/**
 * @author Eugene Tsydzik
 * @since 10/05/16.
 */
public class Cashier implements Runnable {
    int number;

    public Cashier() {
        number = Dispatcher.countCashier.incrementAndGet();
    }

    @Override
    public void run() {
        do {
            if (QueueBuyer.needService()) {
                Buyer buyer = QueueBuyer.extract();
                System.out.println(this + " ... Start " + buyer);
                Helper.sleep(Helper.rnd(1000));
                System.out.println(this + " ... Billing " + buyer);
                System.out.println(this + " ... Stop " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
        while (Dispatcher.needCashier());
        Dispatcher.countCashier.decrementAndGet();

        System.out.println("-------->>>>>>>>>>>>>> STOP");
    }

    @Override
    public String toString() {
        return "Cashier № " + number;
    }
}
