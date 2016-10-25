package by.it.laurynovich.jd01.jd01_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nadabratb on 09.10.2016.
 */
public class MyCollect {
    protected static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> cross = new HashSet<>();
        cross.addAll(a);
        cross.retainAll(b);
        return cross;
    }

    protected static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> union = new HashSet<>();
        union.addAll(a);
        union.addAll(b);
        return union;
    }
}
