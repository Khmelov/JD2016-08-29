package by.it.sukora.jd01_12.HomeWork;


import java.util.ArrayList;
import java.util.List;

public class TaskA {
    //A1
    public static ArrayList listArray(int size) {
        ArrayList<Integer> marks = new ArrayList<>();
        ArrayList<Integer> negativMarks = new ArrayList<>();
        ArrayList<ArrayList> result = new ArrayList();
        for (int i = 0; i < size; i++) {
            int j = (int) Math.round(Math.random() * 10);
            marks.add(j);
            if (j < 4) {
                negativMarks.add(j);
            }
        }

        result.add(new ArrayList<>(marks));
        marks.removeAll(negativMarks);
        result.add((ArrayList) marks);
        return result;
    }

    //A3
    public static ArrayList<ArrayList> moveNegativeToEnd(int size) {
        List<Integer> list = new ArrayList();
        List<Integer> negativeItems = new ArrayList();
        ArrayList<ArrayList> result = new ArrayList();
        for (int i = 0; i < size; i++) {
            int item = ((int) (Math.random() * 21) - 10);
            list.add(item);
            if (item < 0) {
                negativeItems.add(item);
            }
        }
        result.add(new ArrayList(list));
        list.removeAll(negativeItems);
        list.addAll(negativeItems);
        result.add((ArrayList) list);
        return result;
    }
}

