package by.it.tsydzik.jd01_12;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author Eugene Tsydzik
 * @since 15.10.16.
 */
public class TaskB1 {
    public static void task() {
        String text = Data.TEXT;
        List<String> words = Stream.of(text.split("\\W"))
                .filter(s -> !s.isEmpty())
                .collect(toList());
        System.out.println("Unique words");
        HashMap<String, Long> collect = words.stream().collect(groupingBy(
                s -> s,
                HashMap::new,
                counting()
        ));
        System.out.println(collect);

    }

}
