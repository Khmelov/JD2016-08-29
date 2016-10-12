package by.it.rudzko.jd_02_03;

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
