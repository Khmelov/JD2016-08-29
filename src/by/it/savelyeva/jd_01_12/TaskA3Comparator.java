package by.it.savelyeva.jd_01_12;
/**
 * Created by nato on 9/28/16.
 */
public class TaskA3Comparator<T> implements Comparator<T> {
	@Override
	public int compare(T a, T b) {
		if (Integer.parseInt(a.toString()) < 0) return 1;
		else return -1;
	}
}
