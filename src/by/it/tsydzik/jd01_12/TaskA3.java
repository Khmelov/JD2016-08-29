package by.it.tsydzik.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Eugene Tsydzik
 * @since 15.10.16.
 */
public class TaskA3 {
    public static void task() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, 0, -2, -3, -4, -5));
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
