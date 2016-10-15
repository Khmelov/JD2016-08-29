package by.it.tsydzik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Eugene Tsydzik
 * @since 15.10.16.
 */
public class TaskA1 {
    public static void task(int count) {
        ArrayList<Integer> ratingsList = new ArrayList<>(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            ratingsList.add(random.nextInt(10) + 1);
        }
        System.out.println("All students assessment");
        System.out.println(ratingsList);

        Iterator<Integer> iterator = ratingsList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 4) {
                iterator.remove();
            }
        }
        System.out.println("All students assessment");
        System.out.println(ratingsList);
    }
}
