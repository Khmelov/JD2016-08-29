package by.it.artiuschik.jd_01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA3 {
    //числа от -10  до 10
    public static ArrayList<ArrayList> moveNegativeToEnd(int arraySize){
            List<Integer> list = new ArrayList();
            List<Integer> negativeItems = new ArrayList();
            ArrayList<ArrayList> result=new ArrayList();
            for (int i = 0; i < arraySize; i++) {
                int item = ((int)(Math.random() * 21)-10);
                list.add(item);
                if (item < 0) {
                    negativeItems.add(item);
                }
            }
            result.add(new ArrayList(list));
            list.removeAll(negativeItems);
            list.addAll(negativeItems);
            result.add((ArrayList)list);
            return result;
        }
}
