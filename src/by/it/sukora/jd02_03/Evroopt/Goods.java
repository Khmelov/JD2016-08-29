package by.it.sukora.jd02_03.Evroopt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Goods {
    private static Map<String, Double> table = new HashMap<String, Double>();
    private static List<String> names;

    static {
        table.put("Хлеб ", 1.0);
        table.put("Молоко", 2.0);
        table.put("Йогурт", 0.50);
        table.put("Банан", 1.56);
        table.put("Печеньки", 4.93);
        table.put("Пиво", 2.36);
        table.put("Сигареты", 2.5);
        names = new ArrayList<>(table.keySet());
    }

    ;

    protected static String random() {

        return names.get(Helper.rnd(names.size() - 1));
    }
}
