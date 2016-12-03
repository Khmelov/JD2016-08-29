package by.it.artiuschik.jd_01_12;
import java.util.*;

class MyGeneralCollect<T> {
    private HashSet<T> generalSet=new HashSet<>();
    @SafeVarargs
    MyGeneralCollect(T... items) {
        generalSet = new HashSet<>();
        Collections.addAll(generalSet, items);
    }
    private MyGeneralCollect(HashSet<T> items)
    {
        generalSet=items;
    }
    static <T>  MyGeneralCollect getCross(MyGeneralCollect<T> a, MyGeneralCollect<T> b) {
        HashSet<T> result = new HashSet<>();
        result.addAll(a.generalSet);
        result.retainAll(b.generalSet);
        return new MyGeneralCollect<>(result);
    }

    static <T> MyGeneralCollect getUnion(MyGeneralCollect<T> a, MyGeneralCollect<T> b) {
        HashSet<T> result = new HashSet<>();
        result.addAll(a.generalSet);
        result.addAll(b.generalSet);
        return new MyGeneralCollect<>(result);
    }

}