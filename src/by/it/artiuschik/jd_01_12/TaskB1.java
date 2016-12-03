package by.it.artiuschik.jd_01_12;

import java.util.HashMap;
import java.util.Map;

class TaskB1 {
    static void wordFrequency(String text) {
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        String[] words = by.it.artiuschik.jd_01_12.Util.words(text);
        for (String word : words) {
                if (wordFrequency.containsKey(word)) {
                    wordFrequency.put(word, wordFrequency.get(word) + 1);
                } else {
                    wordFrequency.put(word, 1);
                }
        }
        for(Map.Entry<String,Integer> entry:wordFrequency.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
