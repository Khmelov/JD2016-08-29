package by.it.vashukevich.jd02_03;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Goods {
    protected static Map<String, Double> table = new HashMap<>();
    private static List<String> names;
    static {
        table.put("Bread ", 1.0);
        table.put("Milk ", 3.0);
        table.put("Cofee ", 30.0);
        table.put("tea ", 13.0);
        table.put("Water ",4.0);
        names = new ArrayList<>(table.keySet());
    }
    protected static String random() {return names.get(Help.fromTo(names.size()-1));}
}
