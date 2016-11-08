package by.it.grishechkin.jd02_03;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Yury on 06.11.2016.
 */
public class Runner {

    public static int plan = 100;  //план
    public static int buyersCount = 40;
    public static int doneBuyers = 0;
    public static int cashierCounts = 5;
    public static int buyerOnRoom = 0;
    public static int enteredBuyer = 0;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(cashierCounts);
        for (int i = 1; i < cashierCounts + 1; i++) {
            executor.execute(new Cashier(i));
        }
        ExecutorService buyerExecutor = Executors.newFixedThreadPool(buyersCount);

        while (enteredBuyer < plan) {
            if (buyerOnRoom <= 10) {
                buyerOnRoom++;
                enteredBuyer++;
                buyerExecutor.execute(new Buyer(enteredBuyer));
                TaskB.sleep(1000);
            }
            else TaskB.sleep(1000);
        }

    }
}
