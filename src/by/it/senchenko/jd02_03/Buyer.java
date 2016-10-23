package by.it.senchenko.jd02_03;

public class Buyer implements Runnable, IBuyer, IBacket {

    private int numBuyer;
    private String nameBuyer;
    double allGoods = 0;

    public String getName() {
        return nameBuyer;
    }

    public void setName(String name) {
        this.nameBuyer = name;
    }
    public Buyer(int number) {
        this.numBuyer = number;
        this.setName("Покупатель №" + number);
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
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i < Helper.rnd(1, 4); i++) {
            Helper.sleep(Helper.rnd(100, 200));
            System.out.format("%s выбрал товар: %s цена товара: %.2f%n", this, Goods.names.get(i), Goods.prices.get(i));
            allGoods += Goods.prices.get(i);
            System.out.format("%.2f общая стоимость покупок %s%n", allGoods, this);
            putGoodsToBacket();
        }
    }

    @Override
    public void goToQueue() {
        synchronized (QueueBuyers.monitorQueueBuyers) {
            QueueBuyers.add(this);
            System.out.println(this + " занял место в очереди");
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
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " положил товары в корзину");
    }

}
