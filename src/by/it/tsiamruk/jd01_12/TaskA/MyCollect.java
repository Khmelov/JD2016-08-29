package by.it.tsiamruk.jd01_12.TaskA;

import java.util.HashSet;

/**
 * Created by waldemar on 28/09/2016.
 */
public class MyCollect {
    public static void getCross(HashSet<Integer> a, HashSet<Integer> b) {
        HashSet<Integer> productOfSets = new HashSet<Integer>();
        productOfSets.addAll(a);
        productOfSets.retainAll(b);

        System.out.println("Пересечение множеств: " + productOfSets.toString());
    }

    public static void getUnion(HashSet<Integer> a, HashSet<Integer> b) {
        HashSet<Integer> unionSets = new HashSet<Integer>();
        unionSets.addAll(a);
        unionSets.addAll(b);
        System.out.println("Объединение множеств: " + unionSets.toString());
    }
}
