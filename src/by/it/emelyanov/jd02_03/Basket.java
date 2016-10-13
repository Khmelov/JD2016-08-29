package by.it.emelyanov.jd02_03;

import java.util.*;

public class Basket {
    public Map<String, Double> goods() {
        Map<String, Double> products = new HashMap<>();
        products.put("Хлеб", 1.3);
        products.put("Курица", 7.2);
        products.put("Чай", 5.5);
        products.put("Кофе", 35.1);
        products.put("Яйца", 1.6);
        products.put("Сыр", 7.8);
        products.put("Морковь", 0.9);
        products.put("Молоко", 1.8);
        products.put("Вода", 2.4);
        products.put("Конфеты", 6.6);
        return products;
    }

    static int takeGoods() {
        int numberOfGoods = (int) Math.round(Math.random() * 4);
        return numberOfGoods;
    }
}
