package by.it.tsiamruk.jd01_12.TaskB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by waldemar on 29/09/2016.
 */
public class TaskB2 {
    public static List getArrayPeoples() {
        List<String> peoples = new ArrayList<String>();
        String[] str = Util.stringOfPeoples;
        Collections.addAll(peoples, str);
        return peoples;
    }

    public static List getLinkedPeoples() {
        List<String> peoples = new LinkedList<String>();
        String[] str = Util.stringOfPeoples;
        Collections.addAll(peoples, str);
        return peoples;
    }

    public static List processArray(List list, int idx) {
        double start = System.nanoTime();
        int listSize = list.size();
        if (idx > listSize)
            return processArray(list, idx - listSize);

        List<String> onePeople = new ArrayList<String>();
        if (idx == 0) {
            onePeople.addAll(list.subList(idx + 1, listSize));
        }
        if (idx != 0) {
            onePeople.addAll(list.subList(idx, listSize));
            onePeople.addAll(list.subList(0, idx - 1));
        }

        int onePeopleSize = onePeople.size();

        if (onePeopleSize > 1) {
            idx = (onePeopleSize < 2) ? 2 - onePeopleSize : 2;
            return processArray(onePeople, idx);
        }
        double end = System.nanoTime();
        double time = end - start;
        System.out.println("Время выполнения программы " + time / 1000 + " микросекунд");
        return onePeople;
    }

    public static List processLinked(List list, int idx) {
        double t = System.nanoTime();
        int listSize = list.size();
        if (idx > listSize)
            return processLinked(list, idx - listSize);

        List<String> onePeople = new LinkedList<String>();
        if (idx == 0) {
            onePeople.addAll(list.subList(idx + 1, listSize));
        }
        if (idx != 0) {
            onePeople.addAll(list.subList(idx, listSize));
            onePeople.addAll(list.subList(0, idx - 1));
        }

        int onePeopleSize = onePeople.size();

        if (onePeopleSize > 1) {
            idx = (onePeopleSize < 2) ? 2 - onePeopleSize : 2;
            return processLinked(onePeople, idx);
        }

        double fin = System.nanoTime();
        double time = fin - t;
        System.out.println("Время выполнения программы: " + time / 1000 + " микросекунд");
        return onePeople;
    }
}
