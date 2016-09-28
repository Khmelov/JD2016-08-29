package by.it.savelyeva.jd_01_12;

import java.util.Random;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by nato on 9/28/16.
 */
public class Util {
	public static ArrayList<Integer> generateArrayListInteger() {
		ArrayList<Integer> m = new ArrayList<Integer>();
		Random randomGenerator = new Random();
		int count = 2 + randomGenerator.nextInt(5);
		for (int i=0; i<count; i++) {
			int power = randomGenerator.nextInt(2);
			m.add((int) (Math.pow(-1, power) * randomGenerator.nextInt(5)));
		}
		return m;
	}

	public static Set<Integer> generateSetInteger() {
		Set<Integer> hs = new HashSet<Integer>();
		Random randomGenerator = new Random();
		int count = 2 + randomGenerator.nextInt(5);
		int i = 0;
		while (i<count) {
			hs.add(randomGenerator.nextInt(5));
			i++;
		}
		return hs;
	}

	@Deprecated //use Util.printIterableCollection(Collection<?> m); implemented below
	public static void printCollection(Collection<?> t) {
		Iterator<?> it = t.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	public static void printCollectionWithHashes(Collection<?> t) {
		Iterator<?> it = t.iterator();
		while (it.hasNext()) {
			Object o = it.next(); 
			System.out.println(o + " <-> " + o.hashCode());
		}
		System.out.println();
	}

	public static void printIterableCollection(Collection<?> m) {
		MyIterator<Object> list = new MyIterator<Object>(m.toArray());
		// Since the class MyIterator is an instance of Iterable, then it can be used in a foreach loop
		for(Object num : list) {
			System.out.print(num + " "); // num.toString() will be printed
		}
		System.out.println();
	}

}
