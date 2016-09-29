package by.it.savelyeva.jd_01_12;

import java.util.HashSet;
import java.util.Set;
/**
 * Created by nato on 9/28/16.
 */
public class MyCollect {
	public static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
		Set<Integer> res = new HashSet<Integer>();
		res.addAll(a);
		res.retainAll(b);
		return res;
	}
	
	public static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
		Set<Integer> res = new HashSet<Integer>();
		res.addAll(a);
		res.addAll(b);
		return res;
	}
}
