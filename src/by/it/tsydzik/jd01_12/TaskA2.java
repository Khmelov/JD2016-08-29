package by.it.tsydzik.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Eugene Tsydzik
 * @since 15.10.16.
 */
public class TaskA2 {
    public static void task() {
        Set<Integer> firstSet = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> secondSet = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        //TODO create copy
        HashSet<Integer> crossSet = new HashSet<>(firstSet);
        crossSet.retainAll(secondSet);
        System.out.println(crossSet);

        HashSet<Integer> unionSet = new HashSet<>(firstSet);
        unionSet.addAll(secondSet);
        System.out.println(unionSet);
    }
}
