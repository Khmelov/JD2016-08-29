package by.it.tsydzik.jd02_03Homework;

import java.util.concurrent.Semaphore;

/**
 * @author Eugene Tsydzik
 * @since 11.10.16.
 */
public class Buyer implements Runnable, IBuyer, IBasket {

    public boolean iWait = false; //флаг того, что покупатель в ожидании
    int number;                    //номер покупателя
    private String name;

    // Чтобы в зале товар выбирало не более 10 человек
    private static Semaphore semaphore = new Semaphore(10);

    public Buyer(int number) {
        this.number = number;
        this.setName("Покупатель №" + number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Покупатель №" + number;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        for (int i = 0; i < Helper.rnd(1, 4); i++) {
            Helper.sleep(Helper.rnd(100, 200));
            String goodName = Goods.random();
            System.out.println(this + " выбрал товар: " + goodName);
            putGoodsToBasket();
        }
    }

    @Override
    public void goToQueue() {
        QueueBuyers.add(this);
        System.out.println(this + " добавлен в очередь");
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goToOut() {
        Dispatcher.countCompleteBuyers.incrementAndGet();
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        try {
            semaphore.acquire();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        goToQueue();
        goToOut();
    }

    @Override
    public void takeBasket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " поместил товары в корзину");
    }
}
