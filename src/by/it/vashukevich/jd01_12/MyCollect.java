package by.it.vashukevich.jd01_12;

import java.util.Set;

/**
 * Created by Admin on 28.09.16.
 */
public class MyCollect {
    public static void getCross(Set<Integer>ar,Set<Integer>br){
        ar.retainAll(br);
        System.out.println("Пересечение множеств"+ar);
    }
    public static void getUniuon(Set<Integer>ar,Set<Integer>br){
        ar.addAll(br);
        System.out.println("Объединение множеств"+ar);
    }
}
