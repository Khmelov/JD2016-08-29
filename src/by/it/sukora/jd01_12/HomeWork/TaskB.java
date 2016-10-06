package by.it.sukora.jd01_12.HomeWork;


import java.util.*;

public class TaskB {
    public static String[] words(String str)
    {
        String[] result=str.split("[^a-zA-Z0-9]+");
        return result;
    }

    public static void worde(String text) {
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        String[] words = words(text);
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

    public static int processArray(int n) {
        List<Integer> array = new ArrayList<>();
        return process(array, n);
    }

    public static int processLinked(int n) {
        List<Integer> linked = new LinkedList<>();
        return process(linked, n);
    }

    private static int process(List<Integer> list, int n) {
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        int counter = 0;
        while (list.size() > 1) {
            if (it.hasNext()) {
                it.next();
                counter++;
                if (counter == 2) {
                    it.remove();
                    counter = 0;
                }

            } else {
                it = list.iterator();
            }
        }
        return list.get(0);
    }

}
