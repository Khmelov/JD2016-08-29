package by.it.grishechkin.jd01_12;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yury on 20.10.2016.
 */
public class Util {

    public static void printIntArr(List<Integer> list) {
        for (Integer value : list) {
            System.out.print(value + "  ");
        }
        System.out.println();
    }

    public static void printStrArr(List<String> list) {
        for (String value : list) {
            System.out.print(value + "  ");
        }
        System.out.println();
    }

    public static void printIntMap(LinkedHashMap map) {
        Iterator<Map.Entry<Integer, Integer>> itr1 = map.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry<Integer, Integer> entry = itr1.next();
            System.out.print(entry.getValue() + "  ");
        }
        System.out.println();
    }

    public static void printIntMap(Map <String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> itr1 = map.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry<String, Integer> entry = itr1.next();
            System.out.println(entry.getValue() + "  " + entry.getKey());
        }
        System.out.println();
    }
}
