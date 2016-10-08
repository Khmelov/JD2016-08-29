package by.it.savelyeva.jd_01_12;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * Created by nato on 9/28/16.
 */
public class TaskC1 {
	public static ArrayList<String> textToArrayList(String s) {
		ArrayList<String> res = new ArrayList<String>();
		String[] lines = s.split(" ");
		for (String line: lines)  res.add(line);
		return res;
	}

	public static Set<String> removeRepeated(ArrayList<String> a, Comparator<String> c) {
		Set<String> res = new TreeSet<>(c);
		res.addAll(a);
		return res;
	}
	
}
