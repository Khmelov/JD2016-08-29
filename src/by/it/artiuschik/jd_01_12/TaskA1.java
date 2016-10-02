package by.it.artiuschik.jd_01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA1 {
    public static ArrayList marksArray(int arraySize) {
        List<Integer> marks = new ArrayList();
        List<Integer> negativeMarks = new ArrayList<>();
        ArrayList<ArrayList> result = new ArrayList();//первоначальный массив и массив с удаленными оценками
        for (int i = 0; i < arraySize; i++) {
            int mark = (int) (Math.random() * 11);
            marks.add(mark);
            if (mark < 4) {
                negativeMarks.add(mark);
            }
        }
        result.add(new ArrayList<>(marks));
        marks.removeAll(negativeMarks);
        result.add((ArrayList)marks);
        return result;
    }
}
