package by.it.ilyukhin.jd01_12;


import java.util.HashSet;
import java.util.Set;

public class MyCollect {
    static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> cross = new HashSet<>(set1);
        cross.retainAll(set2);
        return cross;
    }
    static Set<Integer> getUnion(Set<Integer> set1,Set<Integer> set2){
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }
}
