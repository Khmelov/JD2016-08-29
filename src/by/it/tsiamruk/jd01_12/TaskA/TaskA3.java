package by.it.tsiamruk.jd01_12.TaskA;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by waldemar on 28/09/2016.
 */
public class TaskA3 {
    public static void sortSet(ArrayList arrayList) {
        TreeSet<?> wow = new TreeSet();
        wow.addAll(arrayList);
        System.out.println("Сортированный список " + wow.toString());
    }
}
