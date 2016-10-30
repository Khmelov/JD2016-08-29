package by.it.ilyukhin.jd02_3;


public class Buyer implements IBucket,IBuyer,Runnable {

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
        takeBucket();
        chooseGoods();
        goToQueue();
        goOutTo();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i < Helper.rnd(1, 4); i++) {
            Helper.sleep(Helper.rnd(100, 200));
            String goodName = Goods.random();
            System.out.println(this + " choose good: " + goodName);
            putGoodsToBucket();
        }
    }

    @Override
    public void goToQueue() {
        synchronized (QueueBuyers.monitorQueueBuyers) {
            QueueBuyers.add(this);
            System.out.println(this + " added to QueueBuyers");
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
    public void goOutTo() {
        Dispatcher.countOutBuyers.incrementAndGet();
        System.out.println(this + " go to out from Market");
    }

    @Override
    public String toString() {
        return "Buyer №" + number;
    }

    @Override
    public void takeBucket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " take bucket");
    }

    @Override
    public void putGoodsToBucket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " put goods to bucket");
    }

}

