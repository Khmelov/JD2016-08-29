package by.it.tsydzik.jd02_03Homework;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Cashier implements Runnable {
    int cashierNumber;    //номер кассира

    public Cashier() {
        this.cashierNumber = Dispatcher.countCashiers.incrementAndGet();
    }

    @Override
    public void run() {
        do {
            if (QueueBuyers.needService()) {
                Buyer buyer = QueueBuyers.poll();
                System.out.println(this + " начал обслуживание " + buyer);
                Helper.sleep(Helper.rnd(1000));
                if (buyer != null) {
                    System.out.println(this + " закончил обслуживание " + buyer);
                    synchronized (buyer) {
                        buyer.notify();
                    }
                }
            }
        } while (Dispatcher.needCashiers());
        System.out.println(this + " закрылся");
        Dispatcher.countCashiers.decrementAndGet();
    }

    @Override
    public String toString() {
        return "Кассир-" + cashierNumber;
    }
}
