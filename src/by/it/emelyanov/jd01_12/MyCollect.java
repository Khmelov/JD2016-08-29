package by.it.emelyanov.jd01_12;

import java.util.HashSet;
import java.util.Set;

public class MyCollect {

    static Set<Integer> getCross(Set<Integer> A, Set<Integer> B) {
        Set<Integer> cross = new HashSet<>(A);
        cross.retainAll(B);
        return cross;
    }

    static Set<Integer> getUnion(Set<Integer> A, Set<Integer> B) {
        Set<Integer> union = new HashSet<>(A);
        union.addAll(B);
        return union;
    }
}
