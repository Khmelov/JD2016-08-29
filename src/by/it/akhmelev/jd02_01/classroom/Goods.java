package by.it.akhmelev.jd02_01.classroom;

import java.util.*;

public class Goods {
    private static Map<String, Double> table=new HashMap<String, Double>();
    private static List<String> names;
    static {
        table.put("Bread",1.0);
        table.put("Milk",3.0);
        table.put("Cofee",33.0);
        table.put("Tea",13.0);
        names=new ArrayList<>(table.keySet());
    };
    protected static String random(){
        return names.get(Helper.rnd(names.size()-1));
    }

}
