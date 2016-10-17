package by.it.tsydzik.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Eugene Tsydzik
 * @since 15.10.16.
 */
public class MyCollect {
    public static void task() {
        Set<Integer> firstSet = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> secondSet = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        //TODO you must create a copy
        Set<Integer> cross = getCross(firstSet, secondSet);
        System.out.println(cross);

        Set<Integer> union = getUnion(firstSet, secondSet);
        System.out.println(union);
    }

    public static <T> Set<T> getCross(Set<T> firstSet, Set<T> secondSet) {
        HashSet<T> crossSet = new HashSet<>(firstSet);
        crossSet.retainAll(secondSet);
        return crossSet;
    }

    public static <T> Set<T> getUnion(Set<T> firstSet, Set<T> secondSet) {
        HashSet<T> unionSet = new HashSet<>(firstSet);
        unionSet.addAll(secondSet);
        return unionSet;
    }
}
