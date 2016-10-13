package by.it.tsiamruk.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by waldemar on 03/10/2016.
 */
public class Goods {
    private static Map<String, Double> table = new HashMap<String, Double>();
    private static List<String> names;

    static {
        table.put("Bread", 1.0);
        table.put("Milk", 1.0);
        table.put("Yogurt", 1.0);
        table.put("Sugar", 1.0);
        table.put("Salt", 1.0);
        table.put("Butter", 2.2);
        table.put("Meat", 57.6);
        table.put("Coffee", 12.0);
        table.put("Beer", 2.0);
        table.put("Chicken", 3.5);
        names = new ArrayList<>(table.keySet());

    }

    protected static String random() {
        return names.get(Helper.rnd(names.size() - 1));
    }
}
