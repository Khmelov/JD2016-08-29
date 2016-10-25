package by.it.grishechkin.jd02_01;

/**
 * Created by Yury on 03.10.2016.
 */
public class Buyer extends Thread implements IBuyer {

    private int number;

    public Buyer(int number) {
        this.number = number;
        this.setName("Buyer No " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods() {
        for (int i = 0; i < Helper.rnd(1,4); i++) {
            Helper.sleep(Helper.rnd(100,200));
            String goodName = Goods.random();
            System.out.println(this + " choose good: " + goodName);
            putGoodsToBucket();
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " go to from Market");
    }

    @Override
    public String toString() {
        return "Buyer No " + number;
    }

    @Override
    public void takeBucket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " take Bucket");
    }

    @Override
    public void putGoodsToBucket() {
        Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " take Bucket");
    }
}
