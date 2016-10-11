package by.it.ilyukhin.jd01_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TaskA {
    protected static ArrayList<Integer> listMarks() {
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(8);
        list.add(2);


        return list;
    }

    static ArrayList<Integer> goodMarks() {
        ArrayList<Integer> goodGet = new ArrayList<>();
        for (Integer m = 0; m < listMarks().size(); m++) {
            Integer marks = listMarks().get(m);
            if (marks < 5) {
                listMarks().remove(marks);
            } else {
                goodGet.add(marks);
            }

        }
        return goodGet;
    }

    static Set<Integer> generateSet1(int lenght) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < lenght; i++) {
            set.add(i);
        }

        return set;
    }

    static Set<Integer> generateSet2(int lenght) {
        Set<Integer> set = new HashSet<>();
        for (int i = lenght; i > 3 ; i--) {
            set.add(i);
        }

        return set;
    }
    static ArrayList<Integer> generateElements() {
        ArrayList<Integer> elements = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            elements.add((int) (Math.random() * 30 - 3));
        }
        return elements;
    }
    static ArrayList<Integer> sortElemetns(ArrayList list) {
        ArrayList<Integer> sortedElements = new ArrayList<>(list);
        Collections.sort(sortedElements);
        Collections.reverse(sortedElements);
        return sortedElements;
    }
}


















