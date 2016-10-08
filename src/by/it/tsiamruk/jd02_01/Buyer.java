package by.it.tsiamruk.jd02_01;

/**
 * Created by waldemar on 03/10/2016.
 */
public class Buyer extends Thread implements IBuyer, IBucket {
    private int number;
    private boolean pensioner;

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }


    public boolean isPensioner() {
        return pensioner;
    }

    public Buyer(int number) {
        this.number = number;
        this.setName("Buyer # " + number);
        this.isPensioner();

    }

    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашел в магазин.");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i < Helper.rnd(1, 4); i++) {
            if (pensioner) {
                Helper.sleep(Helper.rnd(150, 300));
            } else {
                Helper.sleep(Helper.rnd(100, 200));
            }
            String goodsName = Goods.random();
            System.out.println(this + " выбрал товары: " + goodsName);
            this.putGoodsToBucket();
        }

    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина.");
    }

    @Override
    public String toString() {
        if (pensioner)
            return "Pensioner #" + number;
        return "Buyer #" + number;
        //this.getName();
    }

    @Override
    public void takeBucket() {
        if (pensioner)
            Helper.sleep(Helper.rnd(150, 300));
        else
            Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " взял корзину для продуктов.");
    }

    @Override
    public void putGoodsToBucket() {
        if (pensioner)
            Helper.sleep(Helper.rnd(150, 300));
        else
            Helper.sleep(Helper.rnd(100, 200));
        System.out.println(this + " кладёт товар в корзину.");
    }
}
