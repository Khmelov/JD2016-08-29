package by.it.rudzko.jd02_01;

import java.util.HashMap;

/**
 * Created by Leta on 04.10.2016.
 */
public interface IBuyer extends Runnable {
    void enterShop();
    void takeBasket();
    HashMap<String, Double> chooseGoods();
    void leaveShop();
}
