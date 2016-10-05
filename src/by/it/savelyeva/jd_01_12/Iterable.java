package by.it.savelyeva.jd_01_12;

import java.util.Iterator;

/**
 * Created by nato on 9/28/16.
 */
public interface Iterable<T> extends java.lang.Iterable<T> {
    public Iterator<T> iterator();
}
