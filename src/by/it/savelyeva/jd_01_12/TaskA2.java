package by.it.savelyeva.jd_01_12;

import java.util.Set;
/**
 * Created by nato on 9/28/16.
 */
public class TaskA2 {

	public static void printCross(Set<Integer> a, Set<Integer> b) {
		System.out.print("set A: ");	Util.printCollection(a);
		System.out.print("set B: ");	Util.printCollection(b);
		Set<Integer> t = MyCollect.getCross(a, b);
		System.out.print("Cross A&B: ");
		Util.printIterableCollection(t); // or: Util.printCollection(t);
	}

	public static void printUnion(Set<Integer> a, Set<Integer> b) {
		System.out.print("set A: ");	Util.printCollection(a);
		System.out.print("set B: ");	Util.printCollection(b);
		Set<Integer> t = MyCollect.getUnion(a, b);
		System.out.print("Union A+B: ");
		Util.printIterableCollection(t); // or: Util.printCollection(t);
	}
}
