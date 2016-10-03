package by.it.tsydzik.jd02_01;

import java.util.*;

/**
 * Created by user on 03.10.2016.
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
