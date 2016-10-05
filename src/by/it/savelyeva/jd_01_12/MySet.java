package by.it.savelyeva.jd_01_12;
/**
 * Created by nato on 9/28/16.
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Generic class
 * @param <T> is a descendant of interface Set
 */
public class MySet<T extends Set> {

	private T setA;
	private T setB;
	private Set<?> setTmp;

	public MySet(T a, T b) {
		this.setA = a;
		this.setB = b;
		this.setTmp = new HashSet<>();
	}
	
	private T getCross() {
		T res = (T) this.setTmp;
		res.addAll(this.setA); 
		res.retainAll(this.setB);
		return res;
	}
	private T getUnion() {
		T res = (T) this.setTmp;
		res.addAll(this.setA);
		res.addAll(this.setB);
		return res;
	}

	@Deprecated
	public void printCollection(T c) {
		Iterator<T> it = c.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	public void printCross() {
		System.out.print("A: "); Util.printIterableCollection(this.setA); // or:printCollection(this.setA);
		System.out.print("B: "); Util.printIterableCollection(this.setB); // or:printCollection(this.setB);
		T res = getCross();
		System.out.print("Cross A&B: ");
		Util.printIterableCollection(res); // or: Util.printCollection(t);//printCollection(res);
	}
	
	public void printUnion() {
		System.out.print("A: "); Util.printIterableCollection(this.setA); // or: printCollection(this.setA);
		System.out.print("B: "); Util.printIterableCollection(this.setB); // or: printCollection(this.setB);
		T res = getUnion();
		System.out.print("Union A+B: ");
		Util.printIterableCollection(res); // or: printCollection(res);
	}

}
