package by.it.savelyeva.jd_02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by nato on 10/3/16.
 */
public class Goods {
    public static Map<String,Double> table = new HashMap<String, Double>();
    public static List<String> names;

    static {
        table.put("Milk", 1.0);
        table.put("Bread", 1.0);
        table.put("Coffee", 10.0);
        table.put("Tee", 2.0);
        table.put("Sugar", 1.0);
        table.put("Salt", 0.5);
        table.put("Candy", 3.0);
        table.put("Butter", 1.0);
        table.put("Meat", 12.0);
        names = new ArrayList<>(table.keySet());
    }

    protected static String randomProduct() {
        return names.get(Helper.rnd(names.size()-1));
    }
}
