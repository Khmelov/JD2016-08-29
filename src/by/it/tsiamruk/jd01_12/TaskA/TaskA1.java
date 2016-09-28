package by.it.tsiamruk.jd01_12.TaskA;

import java.util.ArrayList;
import java.util.Iterator;



/**
 * Created by waldemar on 27/09/2016.
 */
public class TaskA1 {
    public static void firstTask() {
        ArrayList<Integer> rating = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            int val = (int) (Math.random() * 10 + 1);
            rating.add(val);
        }

        ArrayList<Integer> ratingWithoutBads = new ArrayList<Integer>();
        ratingWithoutBads.addAll(0, rating);

        int positiveRate = 0;
        int size = ratingWithoutBads.size();
        Iterator<Integer> it = ratingWithoutBads.iterator();

        while (it.hasNext()) {
            if (it.next() > 4) {
                positiveRate++;
            } else it.remove();
        }

        System.out.println(rating.toString());
        System.out.println(ratingWithoutBads.toString());

    }


}
