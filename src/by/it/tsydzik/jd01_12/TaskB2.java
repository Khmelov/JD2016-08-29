package by.it.tsydzik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

/**
 * @author Eugene Tsydzik
 * @since 15.10.16.
 */
public class TaskB2 {
    public static void task(int count) {
        processArray(count);
        prоcessLinked(count);
    }

    public static void processArray(int count) {
        ArrayList<Integer> arrayList = generateList(count, ArrayList::new);
        long time = processList(arrayList);
        System.out.printf("Computation time for arrayList = %d ns\n", time);
    }

    public static void prоcessLinked(int count) {
        LinkedList<Integer> linkedList = generateList(count, LinkedList::new);
        long time = processList(linkedList);
        System.out.printf("Computation time for linkedList = %d ns\n", time);

    }

    private static <L extends List<Integer>> L generateList(int count,
                                                            Supplier<L> listSupplier) {
        return IntStream.rangeClosed(1, count)
                .boxed()
                .collect(toCollection(listSupplier));
    }

    public static long processList(List<?> list) {
        long start = System.nanoTime();
        Iterator<?> iterator = list.iterator();
        boolean even = false; //чётное
        while (list.size() != 1) {
            iterator.next();
            if (even) {
                iterator.remove();
            }
            even = !even;
            if (!iterator.hasNext()) {
                iterator = list.iterator();
            }
        }
        long end = System.nanoTime();
        return end - start;
    }
}
