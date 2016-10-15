package by.it.tsydzik.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Eugene Tsydzik
 * @since 15.10.16.
 */
public class TaskA3 {
    public static void task() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, 0, -2, -3, -4, -5));

        long start = System.nanoTime();
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        long end = System.nanoTime();
        System.out.printf("Computation time: %d ns\n", (end -start));
        System.out.println(list);
    }
}
