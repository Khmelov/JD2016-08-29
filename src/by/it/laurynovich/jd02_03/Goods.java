package by.it.laurynovich.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nadabratb on 10/16/2016.
 */
public class Goods {

    private static Map<String, Double> table=new HashMap<String, Double>();
    private static List<String> names;

    static {
        table.put("Bread",1.0);
        table.put("Milk",2.0);
        table.put("Coffee",40.0);
        table.put("Tea",13.0);
        table.put("Oil", 20.0);
        table.put("Meat", 8.5);
        names=new ArrayList<>(table.keySet());
    }

    protected static String random(){
        return names.get(Helper.rnd(names.size()-1));
    }
}
