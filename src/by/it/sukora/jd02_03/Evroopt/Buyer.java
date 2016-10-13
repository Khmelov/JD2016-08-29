package by.it.sukora.jd02_03.Evroopt;


public class Buyer implements Runnable, IBuyer, IBacket {

    private int number;
    private boolean pensioner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Buyer(int number) {
        this.number = number;
        this.pensioner = (this.number % 4 == 0) ? true : false;
        this.setName("Buyer № " + this.number + (this.pensioner ? " (pensioner)" : ""));
    }
    public boolean isPensioner() {
        return this.pensioner;
    }
    @Override
    public void run() {
        // Helper.Timer t = new Helper.Timer();
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " Зашёл в  Evroopt");
    }

    @Override
    public void chooseGoods() {
        for (int i = 0; i < Helper.rnd(1, 4); i++) {
            Helper.sleep(Helper.rnd(2000, 5000));
            String goodname = Goods.random();
            System.out.println(this + " положил в корзину: " + goodname);
            putGoodsBacket();
        }


    }

    @Override
    public void goToQueue() {
        synchronized (QueueBuyers.monitorQueueBuyers) {
            QueueBuyers.add(this);
            System.out.println(this + " стал в очередь");
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
        System.out.println(this + " пошёл на выход из Evroopt");
    }

    @Override
    public String toString() {
        return "Покупательr №" + number;
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.rnd(1000, 2000));
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsBacket() {
        Helper.sleep(Helper.rnd(1000, 2000));
        System.out.println(this + " put goods to backet");
    }


}
