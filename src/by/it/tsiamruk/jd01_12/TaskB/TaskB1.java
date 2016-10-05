package by.it.tsiamruk.jd01_12.TaskB;


import java.util.HashMap;


/**
 * Created by waldemar on 28/09/2016.
 */
public class TaskB1 {
    public static HashMap<String, Integer> createHM() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] words = Util.string.split("[^a-zA-Z]+");
        for (int i = 0; i < words.length; i++) {
            if (!hashMap.containsKey(words[i])) {
                hashMap.put(words[i], 1);
            } else {
                hashMap.replace(words[i], hashMap.get(words[i]) + 1);
            }
        }
        System.out.println(hashMap.toString());
        return hashMap;
    }

}
