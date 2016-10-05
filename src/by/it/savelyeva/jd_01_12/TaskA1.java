package by.it.savelyeva.jd_01_12;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Created by nato on 9/28/16.
 */
public class TaskA1 {
	private ArrayList<Integer> allMarks;
	private final ArrayList<Integer> badMarks;
	private final ArrayList<Integer> goodMarks;


	public TaskA1() {
		Integer[] bm = new Integer[] {1, 2, 3};	
		this.badMarks = new ArrayList<Integer>(Arrays.asList(bm));
		Integer[] gm = new Integer[] {4, 5, 6, 7, 8, 9, 10};	
		this.goodMarks = new ArrayList<Integer>(Arrays.asList(gm));
		ArrayList<Integer> am = new ArrayList<Integer>();
		Random randomGenerator = new Random();
		int pupilsCount = 5 + randomGenerator.nextInt(20);
		for (int i=0; i<pupilsCount; i++) {
			am.add(1 + randomGenerator.nextInt(11));
		}
		this.allMarks = am;
	}

	public void printAllMarks() {
		System.out.print("All marks: ");
		Util.printIterableCollection(this.allMarks); // or: Util.printCollection(this.allMarks);
	}
	
	public void printGoodMarks() {
		System.out.print("Good marks: ");
		int bound = badMarks.get(badMarks.size()-1);
		Iterator<Integer> it = (this.allMarks).iterator();
		while (it.hasNext()) {
			int mark = it.next();
			if (mark > bound) System.out.printf("%d ", mark);
			else it.remove();
		}
		System.out.println();
	}
	
	public void printGoodMarksRetained() {
		System.out.print("Good marks (using retain): ");
		ArrayList<Integer> t = new ArrayList<Integer>(this.allMarks);
		t.retainAll(goodMarks);
		Util.printIterableCollection(t); // or: Util.printCollection(t);
	}
}
