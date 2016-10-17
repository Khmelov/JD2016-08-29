package by.it.tsydzik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

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

    public static void taskJ8(int count) {
        ArrayList<Integer> list = IntStream.range(0, count)
                .map(i -> ThreadLocalRandom.current().nextInt(10) + 1)
                .boxed()
                .collect(toCollection(ArrayList::new));
        ArrayList<Integer> result = list.stream()
                .filter(i -> i >= 4)
                .collect(toCollection(ArrayList::new));
        System.out.println(result);
    }
}
