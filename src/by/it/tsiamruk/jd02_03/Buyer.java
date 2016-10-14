package by.it.tsiamruk.jd02_03;

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
        System.out.println(this + " зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        double totalAmount = 0;
        for (int i = 1; i < Helper.rnd(1, 4); i++) {
            Helper.sleep(Helper.rnd(100, 200));
            String goodName = Goods.random();
            double priceOfGood = Goods.getPrice();
            System.out.format("%s выбрал товар: %s цена: %.2f%n", this, goodName, priceOfGood);
            totalAmount += priceOfGood;
            System.out.format("%.2f стоят покупки %s%n", totalAmount, this);
            putGoodsToBacket();
        }
    }

    @Override
    public void goToQueue() {
        QueueBuyers.add(this);
        System.out.println(this + " встал в очередь");
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
        System.out.println(this + " Вышел из магазина");
        ++Dispatcher.countCompleteBuyers;
    }

    @Override
    public String toString() {
        return "Покупатель №" + number;
        //return this.getName();
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " положил товар в корзину");
    }

}
