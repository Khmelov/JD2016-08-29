package by.it.artiuschik.jd_01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class TaskB2 {
    static int processArray(int n) {
        List<Integer> array = new ArrayList<>();
        return process(array, n);
    }

    static int processLinked(int n) {
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
