package by.it.tsiamruk.jd01_12.TaskA;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by waldemar on 27/09/2016.
 */
public class TaskA1 {
    public static void firstTask() {
        List rating = new ArrayList();

        for (int i = 0; i < 10; i++) {
            rating.add((int) (Math.random() * 10 + 1));
        }


        List ratingWithoutBads = new ArrayList();
        for (int i = 0; i < rating.size(); i++) {
            if ((int) (rating.get(i)) > 4)
                ratingWithoutBads.add(rating.get(i));
        }


        System.out.println(rating.toString());
        System.out.println(ratingWithoutBads.toString());

    }


}
