package by.it.rudzko.jd_02_03;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


import static by.it.rudzko.jd_02_03.Cashier.poolCashiers;

/**
 * @author Olga Rudzko
 */

public class Shop {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        long t = System.currentTimeMillis();

        BlockingQueue<Buyer> buyersInside = new ArrayBlockingQueue<>(40);

        while (Buyer.countBuyers.get() < Buyer.AMOUNT_OF_BUYERS) {
            long t2 = System.currentTimeMillis();
            Helper.checkBuyers(buyersInside);  //removes buyers who left the shop from list buyersInside
            try {
                // System.out.println(buyersInside.size() + " buyers iside: " + buyersInside);
                if (((t2 - t) / 1000) % 60 < 30) {                      //checks what half of current minute is it
                    if (buyersInside.size() < 11) {        //checks if the number of buyers inside is not more than 10
                        int amount = Helper.random(2);
                        Helper.createBuyers(amount, buyersInside); //creates buyers and adds them to list buyersInside
                    } else {
                        throw new ArithmeticException();
                    }
                } else {
                    if (buyersInside.remainingCapacity() != 0) {
                        Helper.createBuyers(Integer.MAX_VALUE, buyersInside);  //creates buyers and adds them to list buyersInside
                    } else {
                        throw new ArithmeticException();
                    }
                }
            } catch (ArithmeticException e) {
                System.out.println("Sorry, there're too many buyers in the shop. Please wait somebody leaves.");
            }
            Helper.performing(1000);
        }

        while (!buyersInside.isEmpty()) {
            buyersInside.peek().join();
            Helper.checkBuyers(buyersInside);
        }
        poolCashiers.shutdown();
    }
}

