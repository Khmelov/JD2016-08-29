package by.it.tsydzik.jd01_12;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author Eugene Tsydzik
 * @since 16.10.16.
 */
public class TaskC1 {
    public static void task() {
        String text = Data.TEXT;
        Map<String, Long> wordWithCount = Stream.of(text.split("\\W"))
                .filter(s -> !s.isEmpty())
                .collect(groupingBy(
                        s -> s,
                        TreeMap::new,
                        counting()
                ));
        AtomicInteger index = new AtomicInteger();
        List<WordAndCipher> result = wordWithCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .map(s -> new WordAndCipher(s, index.getAndIncrement()))
                .collect(toList());
        result.forEach(System.out::println);
    }

    static class WordAndCipher {
        final String word;
        final int cipher;

        public WordAndCipher(String word, int cipher) {
            this.word = word;
            this.cipher = cipher;
        }

        @Override
        public String toString() {
            return "{word='" + word + '\'' +
                    ", cipher=" + cipher +
                    "}";
        }
    }
}
