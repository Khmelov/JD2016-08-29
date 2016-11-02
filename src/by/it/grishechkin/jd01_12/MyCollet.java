package by.it.grishechkin.jd01_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Yury on 20.10.2016.
 */
public class MyCollet {

    public static List<Integer> getCross(List<Integer> A, List<Integer> B) {

        List<Integer> cross  = new ArrayList<>(A);
        cross.retainAll(B);
        HashSet <Integer> rez = new HashSet<>(cross);
        return new ArrayList<>(rez);
    }

    public static List getUnion(List<Integer> A, List<Integer> B) {

        List<Integer> rez = new ArrayList<>(A);
        rez.addAll(B);
        return rez;
    }
}
