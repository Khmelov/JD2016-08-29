package by.it.sukora.jd02_01.Evroopt;

import java.util.*;

public class Goods {
    private static Map<String, Double> table = new HashMap<String, Double>();
    private static List<String> names;

    static {
        table.put("Bread", 1.0);
        table.put("Milk", 2.0);
        table.put("Yuogurt", 0.50);
        table.put("Banana", 1.56);
        table.put("Cookis", 4.93);
        table.put("Pivo", 2.36);
        table.put("Sigarets", 2.5);
        names = new ArrayList<>(table.keySet());
    }

    ;

    protected static String random() {

        return names.get(Helper.rnd(names.size() - 1));
    }
}
