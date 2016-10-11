package by.it.rudzko.jd_02_03_pre;

/**
 * @author Olga Rudzko
 */
public interface IBuyer extends Runnable {
    void enterShop();

    void takeBasket();

    void chooseGoods();

    void gotoQueue();

    void leaveShop();
}
