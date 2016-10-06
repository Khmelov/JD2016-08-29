package by.it.sukora.jd01_12.HomeWork;


import java.util.HashSet;

public class MyCollect {
    private HashSet<Integer> integerSet;

    public MyCollect() {
        integerSet = new HashSet<>();
    }

    public MyCollect(int... items) {
        integerSet = new HashSet<>();
        for (int i = 0; i < items.length; i++) {
            integerSet.add(items[i]);
        }
    }

    @Override
    public String toString() {
        return integerSet.toString();
    }

    public MyCollect(HashSet integerSet) {
        this.integerSet = integerSet;
    }

    public static MyCollect getCross(MyCollect a, MyCollect b) {
        MyCollect cross = getUnion(a, b);
        HashSet<Integer> s1 = new HashSet(a.integerSet);
        HashSet<Integer> s2 = new HashSet(b.integerSet);
        s1.removeAll(b.integerSet);
        s2.removeAll(a.integerSet);
        s1.addAll(s2);
        cross.integerSet.removeAll(s1);
        return cross;
    }

    public static MyCollect getUnion(MyCollect a, MyCollect b) {
        MyCollect union = new MyCollect();
        union.integerSet.addAll(a.integerSet);
        union.integerSet.addAll(b.integerSet);
        return union;
    }
}
