package by.it.rudzko.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Olga Rudzko
 */
public class Cashier implements Runnable {

    private int number;
    static public AtomicInteger countCashiers = new AtomicInteger(0);

    public Cashier() {
        int n = countCashiers.incrementAndGet() % 5;
        this.number = (n != 0) ? n : 5;
    }

    static ExecutorService poolCashiers = Executors.newFixedThreadPool(5);

    @Override
    public void run() {
        if (QueueBuyers.notEmpty()) {
            Buyer x = QueueBuyers.serve();
            System.out.println(this + " invites " + x);
            Helper.performing(Helper.random(2000, 5000));
            Helper.printBill(this, this.number, x);
            synchronized (x) {
                x.notify();
            }
        }
    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }
}
