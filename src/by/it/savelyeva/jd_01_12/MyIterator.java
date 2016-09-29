package by.it.savelyeva.jd_01_12;

import java.util.Iterator;

/**
 * Created by nato on 9/28/16.
 */
public class MyIterator<T> implements Iterable<T> {

    private T[] arrayList;
    private int currentSize;

    public MyIterator(T[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public T next() {
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}