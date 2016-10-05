package by.it.savelyeva.jd_01_12;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by nato on 9/28/16.
 */

/**
 * The class contains annotated methods which work with Maps (generate & navigate through HashMap, WeakHashMap, TreeMap).
 * Methods, annotated with "GetElapsedTime" will provide their timing when the methods are called on an object.
 * This is done using reflection method invokeThis() implemented below.
 * This class is a generic class, Integer and Double are supported to work as the type T.
 */

public class Benchmark<T> {
    private HashMap<String,T> hm;
    private WeakHashMap<String,T> whm;
    private TreeMap<String,T> tm;

    public Benchmark() {
        this.hm = generateHashMap();
        this.whm = generateWeakHashMap();
        this.tm = generateTreeMap();
    }

    /**
     * Static method, used for reflection and which can be applied to objects of any type.
     * @param obj - any object we want to measure execution time of methods, annotated with GetElapsedTime.
     */

    public static void invokeThis(Object obj) {
        try {
            Method[] methods = Class.forName(obj.getClass().getName()).getMethods();
            for (int i=0; i<methods.length; i++) {
                GetElapsedTime annotime = methods[i].getAnnotation(GetElapsedTime.class);
                if (annotime != null) {
                    System.out.println();
                    System.out.println(methods[i].toString());
                    System.out.println(annotime.description());
                    Timer t = new Timer();
                    methods[i].invoke(obj, null);
                    System.out.println(t);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Internal method which generates a map of Map<String,T> type
     * @param map - can be an object of TreeMap, HashMap, WeakHashMap types.
     * @return map of Map<String,T> type.
     */
    private Map<String,T> generateMap(Map<String,T> map) {
        Double value = new Double(0);
        while (value<1000) {
            String key = Double.toString(value);
            map.put(key, (T) value);
            value += 1;
        }
        return map;
    }

    /**
     * Method does nothing - just iterates through all entries of a given map.
     * To add printing feature uncomment printing line.
     * @param map - a map to be iterated through (can be an object of TreeMap, HashMap, WeakHashMap types)
     */
    private void iterateMap(Map<String,T> map) {
        for (Map.Entry entry: map.entrySet()) {
            //System.out.println(entry.getKey() + " <-> " + entry.getValue());
        }
    }

    @GetElapsedTime(description = "Generate HashMap")
    public HashMap<String,T> generateHashMap() {
        HashMap<String,T> hm = new HashMap<String,T>();
        return (HashMap<String,T>) generateMap(hm);
    }

    @GetElapsedTime(description = "Generate WeakHashMap")
    public WeakHashMap<String,T> generateWeakHashMap() {
        WeakHashMap<String,T> whm = new WeakHashMap<String,T>();
        return (WeakHashMap<String,T>) generateMap(whm);
    }

    @GetElapsedTime(description = "Generate TreeMap")
    public TreeMap<String,T> generateTreeMap() {
        TreeMap<String,T> tm = new TreeMap<String,T>();
        return (TreeMap<String,T>) generateMap(tm);
    }

    @GetElapsedTime(description = "Navigate through entire HashMap")
    public void printHashMap() {
        iterateMap(this.hm);
    }

    @GetElapsedTime(description = "Navigate through entire WeakHashMap")
    public void printWeakHashMap() {
        iterateMap(this.whm);
    }

    @GetElapsedTime(description = "Navigate through entire TreeMap")
    public void printTreeMap() {
        iterateMap(this.tm);
    }
}
