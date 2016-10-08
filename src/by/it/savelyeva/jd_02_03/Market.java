package by.it.savelyeva.jd_02_03;

/**
 * Created by nato on 10/5/16.
 */

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Dispatcher class
 * Declare counteers atomic so we will not need monitors
 */
public class Market {
    static AtomicInteger countCashiers = new AtomicInteger(0);
    static AtomicInteger countBuyers = new AtomicInteger(0);
    static AtomicInteger countBuyersOut = new AtomicInteger(0);
    static final int PLAN_BUYERS_COUNT = 100;
    static ExecutorService poolCashiers = Executors.newFixedThreadPool(5);

    static final Integer monitorTotalIncome = 0;
    private static double totalIncome = 0;

    public static double getTotalIncome() {
        return totalIncome;
    }

    public static void incrementTotalIncome(double increment) {
        synchronized (monitorTotalIncome) {
            totalIncome += increment;
        }
    }

    static boolean isPlanCompleted() {
        return (countBuyersOut.get() >= PLAN_BUYERS_COUNT);
    }

    static boolean needCashiers() {
        if (!Market.isPlanCompleted()) {
            if (countCashiers.get() < 5 && (countCashiers.get()*5 < QueueBuyers.getSize())) {
                return true;
            }
        } else if (countCashiers.get() < 5
                && Market.countBuyers.get() != Market.countBuyersOut.get()
                && QueueBuyers.needService()) {
                return true; // i.e. we will need cashiers even when plan gets completed if we have buyers inside
            }
        return false;
    }

    public static void shutdownCashiersPool() {
        while (countBuyers.get() != countBuyersOut.get()) {
            Helper.sleep(1000);
        }
        Market.poolCashiers.shutdown();
    }

    public static void makeBilling(Cashier cashier, Buyer buyer) {
        Map<String,Double> basket = buyer.getBasket();
        Iterator<String> it = basket.keySet().iterator();
        double total = 0;
        while (it.hasNext()) {
            String productName = it.next();
            incrementTotalIncome(Goods.table.get(productName));
            total += Goods.table.get(productName);
            Helper.printReportLine(cashier.getNumber(),
                    String.format("%-20s", productName + " " + Goods.table.get(productName) + " BYN"));
        }
        Helper.printReportLine(cashier.getNumber(),
                String.format("%-20s", "Total: " + String.format("%4.2f", total) + " BYN"));
    }

    public static void print() {
        System.out.printf(
                "TOTAL: Cashiers = %d; Buyers = %d; Buyers Out = %d; Plan done: %s; Need cashiers: %s; Queue size = %d\n",
                countCashiers.get(), countBuyers.get(), countBuyersOut.get(),
                isPlanCompleted(), Market.needCashiers(), QueueBuyers.getSize()
        );
        QueueBuyers.print();
    }

}
