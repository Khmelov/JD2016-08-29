package by.it.tsiamruk.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Goods {
    private static Map<String, Double> table = new HashMap<String, Double>();
    private static List<String> names;
    private static List<Double> prices;
    static {
        table.put("Bread", 1.0);
        table.put("Milk", 3.0);
        table.put("Cofee", 33.0);
        table.put("Tea", 13.0);
        names = new ArrayList<>(table.keySet());
        prices = new ArrayList<>(table.values());

    }

    ;

    protected static String random() {
        return names.get(Helper.rnd(names.size() - 1));
    }

    protected static Double getPrice() {
        int index = names.indexOf(random());
        return prices.get(index);
    }
}
