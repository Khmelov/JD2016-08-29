package by.it.savelyeva.jd_02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * Created by nato on 10/3/16.
 */
public class Buyer extends Thread implements IBuyer, IUseBasket {
    private int number;
    private boolean pensioner;
    private Map<String,Double> basket;
    private static Semaphore semaphore = new Semaphore(10);

    public Buyer(int number) {
        this.number = number;
        this.pensioner = (this.number % 4 == 0) ? true : false;
        this.setName("Buyer № " + this.number + (this.pensioner ? " (pensioner)" : ""));
        this.basket = new HashMap<>();
    }

    public boolean isPensioner() {
        return this.pensioner;
    }

    @Override
    public void enterMarket() {
        System.out.printf("%s entered market\n", this);
    }

    @Override
    public void chooseGoods() {
        int sleepTime = (this.pensioner) ? (int) Math.round(1.5 * Helper.rnd(500, 2000)) : Helper.rnd(500, 2000);
        Helper.sleep(sleepTime);
        for (int i=1; i<=Helper.rnd(1,4); i++) {
            String productName = Goods.randomProduct();
            System.out.printf("%s chose goods: %s, %.2f BYN\n", this, productName, Goods.table.get(productName));
            putToBasket(productName);
        }
    }

    @Override
    public void gotoQueue() {
        QueueBuyers.addBuyer(this);
        System.out.printf("%s added to Queue\n", this);
        //Market.print();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.printf("%s exiting market\n", this);
        Market.countBuyersOut.incrementAndGet();
    }

    @Override
    public void run() {
        enterMarket();
        takeBasket();
        try {
            semaphore.acquire();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        gotoQueue();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        int sleepTime = (this.pensioner) ? (int) Math.round(1.5 * Helper.rnd(100, 200)) : Helper.rnd(100, 200);
        Helper.sleep(sleepTime);
        System.out.printf("%s took basket\n", this);
    }

    public Map<String, Double> getBasket() {
        return basket;
    }

    @Override
    public void putToBasket(String productName) {
        int sleepTime = (this.pensioner) ? (int) Math.round(1.5 * Helper.rnd(100, 200)) : Helper.rnd(100, 200);
        Helper.sleep(sleepTime);
        this.basket.put(productName, Goods.table.get(productName));
        System.out.printf("%s put %s to basket\n", this, productName);
    }
}
