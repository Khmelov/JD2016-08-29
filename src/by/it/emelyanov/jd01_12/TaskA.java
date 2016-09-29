package by.it.emelyanov.jd01_12;

import java.util.*;

public class TaskA {

    static ArrayList<Integer> generateMarks(int length) {
        ArrayList<Integer> marks = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            marks.add((int) (Math.random() * 10 + 1));
        }
        return marks;
    }

    static ArrayList<Integer> deleteMarks(ArrayList<Integer> listOfMarks) {
        Iterator<Integer> it = listOfMarks.iterator();
        while (it.hasNext()) {
            Integer mark = it.next();
            if (mark < 4) {
                it.remove();
            }
        }
        listOfMarks.trimToSize();
        return listOfMarks;
    }

    static Set<Integer> generateSet(int size, int offset) {
        Set<Integer> set = new HashSet<>();
        for (int i = offset; i < (size + offset); i++) {
            set.add(i);
        }
        return set;
    }

    static ArrayList<Integer> generateElements(int length) {
        ArrayList<Integer> marks = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            marks.add((int) (Math.random() * 30 - 15));
        }
        return marks;
    }

    static ArrayList<Integer> sortElemetns(ArrayList list) {
        ArrayList<Integer> sortedElements = new ArrayList<>(list);
        Collections.sort(sortedElements);
        Collections.reverse(sortedElements);
        return sortedElements;
    }
}
