package by.it.grishechkin.jd02_03;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yury on 06.11.2016.
 */
public class Goods {
    private String name;
    private double price;
    Map<String, Double> goods = new HashMap<>();

    public Goods() {
        goods.put("Молоко", 2.00);
        goods.put("Хлеб", 1.58);
        goods.put("Сахар", 2.56);
        goods.put("Соль", 0.94);
        goods.put("Мука", 4.65);
        goods.put("Греча", 3.21);
        goods.put("Рис", 2.15);
        goods.put("Сыр", 5.65);
        goods.put("Чай", 8.39);
        goods.put("Кофе", 5.24);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<String, Double> getGoods() {
        return goods;
    }
}
