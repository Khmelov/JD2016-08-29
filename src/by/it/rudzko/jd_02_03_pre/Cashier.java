package by.it.rudzko.jd_02_03_pre;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Olga Rudzko
 */
public class Cashier implements Runnable {

    int number;
    static public AtomicInteger countCashiers = new AtomicInteger(0);

    public Cashier() {
        int n = countCashiers.incrementAndGet() % 5;
        this.number = (n != 0) ? n : 5;
    }

    static ExecutorService poolCashiers = Executors.newFixedThreadPool(5);
    static AtomicInteger countServed = new AtomicInteger(0);

    static boolean needCashier() {
        boolean res = (QueueBuyers.getSize() - countCashiers.get() >= 5);
        if (countCashiers.get() >= 5 && res)
            res = false;
        return res;
    }

    @Override
    public void run() {
        do {
            if (QueueBuyers.notEmpty()) {
                Buyer x = QueueBuyers.serve();
                System.out.println(this + " invites " + x);
                Helper.performing(Helper.random(2000, 5000));
                System.out.println("\n" + this + " served " + x + ".\n____Bill:____\n" + x.choice);
                System.out.println("--------------");
                Double bill=0.0;
                Iterator<Map.Entry<String, Double>> it=x.choice.entrySet().iterator();
                while (it.hasNext()){
                    bill+=it.next().getValue();
                }
                System.out.println("Total     "+bill+"\n");
                synchronized (x) {
                    x.notify();
                }
                countServed.incrementAndGet();
            }
        }
        while (needCashier());
        System.out.println(this + " closed.");

    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }
}
