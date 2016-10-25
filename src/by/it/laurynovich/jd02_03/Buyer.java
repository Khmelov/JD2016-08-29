package by.it.laurynovich.jd02_03;


/**
 * Created by nadabratb on 10/15/2016.
 */
public class Buyer  implements Runnable, IBuyer, IUseBasket {


    private int number;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Buyer(int number) {
        this.number = number;
        this.setName("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " go to the shop");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i < Helper.rnd(1, 4); i++) {
            Helper.sleep(Helper.rnd(100, 200));
            String goodName = Goods.random();
            System.out.println(this + " chose good: " + goodName);
            putGoodsToBasket();
        }
    }

    @Override
    public void goToQueue() {
        synchronized (QueueBuyers.monitorQueueBuyers) {
            QueueBuyers.add(this);
            System.out.println(this + " added to queue");
        }

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
        Dispatcher.countOutBuyers.incrementAndGet();
        System.out.println(this + " go out from the shop");
    }

    @Override
    public String toString() {
        return "Buyer №" + number;

    }

    @Override
    public void takeBasket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " take the basket");
    }

    @Override
    public void putGoodsToBasket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " put goods to the basket");
    }
}
