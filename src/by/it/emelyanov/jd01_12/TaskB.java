package by.it.emelyanov.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB {

    static HashMap<String, Integer> createHM() {
        HashMap<String, Integer> wordsInHM = new HashMap<>();
        String[] words = EnglishTextTaskB.englishText.split("[^a-zA-Z]+");
        for (int i = 0; i < words.length; i++) {
            if (!wordsInHM.containsKey(words[i])) {
                wordsInHM.put(words[i], 1);
            } else {
                wordsInHM.replace(words[i], wordsInHM.get(words[i]) + 1);
            }
        }
        return wordsInHM;
    }

    static String processArray(int length) {
        double start = System.nanoTime();
        ArrayList<Integer> persons = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            persons.add(i);
        }
        Util.print("ArrayList ", persons);

        while (persons.size() > 1) {
            Iterator<Integer> it = persons.iterator();
            while (it.hasNext()) {
                it.next();
                if (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
        }
        double end = System.nanoTime();
        double time = end - start;
        return "Удаление в ArrayList " + time / 1000 + " микросекунд";
    }


    static String processLinked(int length) {
        double start = System.nanoTime();
        LinkedList<Integer> persons = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            persons.add(i);
        }
        Util.print("\nLinkedList ", persons);

        while (persons.size() > 1) {
            Iterator<Integer> it = persons.iterator();
            while (it.hasNext()) {
                it.next();
                if (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
        }
        double end = System.nanoTime();
        double time = end - start;
        return "Удаление в LinkedList " + time / 1000 + " микросекунд";
    }
}
