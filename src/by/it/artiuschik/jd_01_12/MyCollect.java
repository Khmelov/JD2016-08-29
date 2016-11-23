package by.it.artiuschik.jd_01_12;

import java.util.HashSet;

class MyCollect {
    private HashSet<Integer> integerSet=new HashSet<>();

    MyCollect(int... items) {
        integerSet = new HashSet<>();
        for (int item : items) {
            integerSet.add(item);
        }
    }
    private MyCollect(HashSet<Integer> items)
    {
        integerSet=items;
    }

    @Override
    public String toString() {
        return integerSet.toString();
    }

    static MyCollect getCross(MyCollect a, MyCollect b) {
        HashSet<Integer> result = new HashSet<>();
        result.addAll(a.integerSet);
        result.retainAll(b.integerSet);
        return new MyCollect(result);
    }

    static MyCollect getUnion(MyCollect a, MyCollect b) {
        HashSet<Integer> result = new HashSet<>();
        result.addAll(a.integerSet);
        result.addAll(b.integerSet);
        return new MyCollect(result);
    }

}
