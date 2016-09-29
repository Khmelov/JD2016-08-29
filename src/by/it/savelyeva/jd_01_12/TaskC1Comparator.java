package by.it.savelyeva.jd_01_12;

/**
 * Created by nato on 9/28/16.
 */

public class TaskC1Comparator<T> implements Comparator<T> {
    @Override
    public int compare(T a, T b) {
        if (a.hashCode() > b.hashCode()) return 1;
        else if (a.hashCode() < b.hashCode()) return -1;
        else return 0;
    }
}
