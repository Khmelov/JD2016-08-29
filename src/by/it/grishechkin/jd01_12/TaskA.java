package by.it.grishechkin.jd01_12;

import java.util.*;

/**
 * Created by Yury on 20.10.2016.
 */
public class TaskA {

    public static List<Integer> markList() {
        List <Integer> marks = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            marks.add((int) Math.round(Math.random()*10));
        }
        return marks;
    }

    public static List deleteNegativeMarks(List<Integer> marks, int deadLine) {

       List <Integer> linkedList = new LinkedList<>(marks);
        Iterator <Integer> it = linkedList.iterator();
        while (it.hasNext()) {
            if (it.next() < deadLine) it.remove();
        }
        List <Integer> newMark = new ArrayList<>(linkedList);
        return newMark;
    }

    public static List addNegativeNumbers(List<Integer> marks) {
        List <Integer> rez = new ArrayList<>();
        Iterator <Integer> it = marks.iterator();
        int i = -1;
        for (Integer value : marks) {
            rez.add(value * i);
            i *= -1;
        }
        return rez;
    }

    public static List swap(List<Integer> list) {

        for (int j = 0; j < list.size(); j++) {

            if(list.get(j) < 0) {
                list.add(list.get(j));
                list.remove(j);
            }
        }
        return list;
    }
}
