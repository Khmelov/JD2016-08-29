package by.it.tsydzik.jd02_01;

import java.util.*;

/**
 * @author Eugene Tsydzik
 * @since 10/03/16.
 */
public class Goods {

    static Map<String, Double> table = new HashMap<String, Double>();
    private static List<String> names;

    static {
        table.put("Bread", 1.0);
        table.put("Milk", 3.0);
        table.put("Cofee", 33.0);
        table.put("Tea", 13.0);
        names = new ArrayList<>(table.keySet());
    }

    public static String random() {
        return names.get(Helper.rnd(names.size() - 1));
    }

}
