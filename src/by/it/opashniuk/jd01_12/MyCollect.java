package by.it.opashniuk.jd01_12;

import java.util.HashSet;
import java.util.Set;

public class MyCollect {
    public static void getCross(Set<Integer>ar,Set<Integer>br){
        Set<Integer> result1 = new HashSet<Integer>();
        result1.addAll(ar);
        result1.retainAll(br);
        System.out.println("Пересечение множеств"+result1);
    }
    public static Set getUniuon(Set<Integer>ar,Set<Integer>br){
        Set<Integer> result2 = new HashSet<Integer>();
        result2.addAll(ar);
        result2.addAll(br);
        System.out.println("Объединение множеств"+result2);
        return result2;
    }

}
