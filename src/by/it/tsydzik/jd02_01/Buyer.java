package by.it.tsydzik.jd02_01;

/**
 * @author Eugene Tsydzik
 * @since 10/03/16.
 */
public class Buyer implements Runnable, IBuyer, IBacket {

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
    public String toString() {
        return "Buyer №" + number;
//        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        for (int i = 0; i < Helper.rnd(1, 4); i++) {
            Helper.sleep(Helper.rnd(100, 200));
            String goodName = Goods.random();
            System.out.println(this + " choose good: " + goodName);
            putGoodsToBacket();
        }
    }

    @Override
    public void goToQueue() {
        synchronized (QueueBuyer.monitorQueueBuyer) {
            QueueBuyer.add(this);
            System.out.println(this + " added to QueueBuyer");
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
        System.out.println(this + " go to out");
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " take backet");
    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " put goods to backet");
    }
}
