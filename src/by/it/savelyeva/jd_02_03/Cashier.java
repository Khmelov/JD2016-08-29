package by.it.savelyeva.jd_02_03;

/**
 * Created by nato on 10/5/16.
 */
public class Cashier implements Runnable {
    private int number;

    public int getNumber() {
        return this.number;
    }

    public Cashier() {
        this.number = Market.countCashiers.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Cashier № " + this.number;
    }

    @Override
    public void run() {
        do {
            if (QueueBuyers.needService()) {
                Buyer buyer = QueueBuyers.poll();
                System.out.printf("%s started service for %s\n", this, buyer);
                Helper.sleep(Helper.rnd(1000));
                if (buyer != null) {
                    Market.makeBilling(this, buyer);
                    System.out.printf("%s stopped service for %s\n", this, buyer);
                    synchronized (buyer) {
                        buyer.notify();
                    }
                }
            }
        } while (Market.needCashiers());
        System.out.printf("%s closed\n", this);
        Market.countCashiers.decrementAndGet();
    }

}
