package by.it.tsiamruk.jd01_12.TaskB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by waldemar on 29/09/2016.
 */
public class TaskB2 {
    public static ArrayList<Integer> getArrayPeoples(int value) {
        List<Integer> peoples = new ArrayList<Integer>();
        for (int i = 0; i < value; i++) {
            peoples.add(i);
        }
        return ((ArrayList<Integer>) peoples);
    }

    public static LinkedList<Integer> getLinkedPeoples(int value) {
        List<Integer> peoples = new LinkedList<Integer>();
        for (int i = 0; i < value; i++) {
            peoples.add(i);
        }
        return ((LinkedList<Integer>) peoples);
    }

    public static ArrayList<Integer> processArray(ArrayList<Integer> list) {
        double a = System.nanoTime();
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i += 2) {
                list.remove(i);
            }
        }
        double b = System.nanoTime();
        double res = b - a;
        System.out.println("Результат работы метода processArray:" + list + " Время выполнения: " + res);
        return list;
    }

    public static LinkedList<Integer> processLinked(LinkedList<Integer> list) {
        double a = System.nanoTime();
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i += 2) {
                list.remove(i);
            }
        }
        double b = System.nanoTime();
        double res = b - a;
        System.out.println("Результат работы метода: " + list + " Время выполнения: " + res);
        return list;
    }
}
