package by.it.rudzko.jd_02_03_pre;

/**
 * Created by Leta on 04.10.2016.
 */
public interface IBuyer extends Runnable {
    void enterShop();
    void takeBasket();
    void chooseGoods();
    void gotoQueque();
    void leaveShop();
}
