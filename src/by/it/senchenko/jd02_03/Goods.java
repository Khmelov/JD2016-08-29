package by.it.senchenko.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Goods {
    public static Map<String, Double> table= new HashMap<>();
    public static List<String> names;
    public static List<Double> prices;

    static {
        table.put("Молоко",3.0);
        table.put("Мясо",21.0);
        table.put("Кефир",7.0);
        table.put("Печенье",23.0);
        names=new ArrayList<>(table.keySet());
        prices = new ArrayList<>(table.values());
    }
}
