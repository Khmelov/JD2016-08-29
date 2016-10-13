package by.it.tsiamruk.jd02_03;

public class Buyer implements Runnable, IBuyer, IBacket {

    private int number;
    private String name;
    private boolean pensioner;

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Buyer(int number) {
        this.isPensioner();
        this.number = number;
        this.setName("Buyer №" + number);
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
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods() {
        double totalAmount = 0;
        for (int i = 1; i < Helper.rnd(1, 4); i++) {
            Helper.sleep(Helper.rnd(100, 200));
            String goodName = Goods.random();
            double priceOfGood = Goods.getPrice();
            System.out.format("%s choose good: %s price: %.2f%n", this, goodName, priceOfGood);
            totalAmount += priceOfGood;
            System.out.format("%.2f is total amount of %s%n", totalAmount, this);
            putGoodsToBacket();
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
    public void goToOut() {
        System.out.println(this + " go to out from Market");
    }

    @Override
    public String toString() {
        if (this.isPensioner())
            return "Pensioner";
        else
            return "Buyer №" + number;
        //return this.getName();
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
