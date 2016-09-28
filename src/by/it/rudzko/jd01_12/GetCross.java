package by.it.rudzko.jd01_12;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Leta on 27.09.2016.
 */
public class GetCross <T extends Object> {
    HashSet<T> a;
    HashSet<T> b;

    public ArrayList<T> cross(HashSet<T> a, HashSet<T> b) {
    ArrayList<T> list = new ArrayList<T>();
    ArrayList<T> copyA=new ArrayList<T>(a);

        for (int i=0; i<a.size(); i++){

            if (b.contains(copyA.get(i)))
                list.add(copyA.get(i));
        }

        return list;
}
}
