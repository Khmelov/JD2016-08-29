package by.it.artiuschik.jd_01_12;

import java.util.Collections;
import java.util.HashSet;

public class MyGeneralCollect<T> {
    private HashSet<T> integerSet;

    public MyGeneralCollect() {
        integerSet = new HashSet<>();
    }

    public MyGeneralCollect(T... items) {
        integerSet = new HashSet<>();
        for (int i = 0; i < items.length; i++) {
            integerSet.add(items[i]);
        }
    }

    public MyGeneralCollect(HashSet<T> integerSet) {
        integerSet = new HashSet<>();
        this.integerSet = integerSet;
    }

    public static MyGeneralCollect getCross(MyGeneralCollect a, MyGeneralCollect b) {
        MyGeneralCollect cross = getUnion(a, b);
        HashSet s1 = new HashSet(a.integerSet);
        HashSet s2 = new HashSet(b.integerSet);
        s1.removeAll(b.integerSet);
        s2.removeAll(a.integerSet);
        s1.addAll(s2);
        cross.integerSet.removeAll(s1);
        return cross;
    }

    public static MyGeneralCollect getUnion(MyGeneralCollect a, MyGeneralCollect b) {
        MyGeneralCollect union = new MyGeneralCollect();
        union.integerSet.addAll(a.integerSet);
        union.integerSet.addAll(b.integerSet);
        return union;
    }

    @Override
    public String toString() {
        return integerSet.toString();
    }
}

