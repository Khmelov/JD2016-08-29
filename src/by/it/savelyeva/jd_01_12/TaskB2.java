package by.it.savelyeva.jd_01_12;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Created by nato on 9/28/16.
 */
public class TaskB2 {
	ArrayList<Integer> al;
	LinkedList<Integer> ll;
	int size;

	public TaskB2() {
		this.size = 100;
		this.al = generateArrayListInteger(this.size);
		this.ll = generateLinkedListInteger(this.size);
	}

	public static ArrayList<Integer> generateArrayListInteger(int size) {
		ArrayList<Integer> m = new ArrayList<Integer>();
		for (int i=0; i<size; i++) {
			m.add(i+1);
		}
		return m;
	}
	
	public static LinkedList<Integer> generateLinkedListInteger(int size) {
		LinkedList<Integer> m = new LinkedList<Integer>();
		for (int i=0; i<size; i++) {
			m.add(i+1);
		}
		return m;
	}

	@GetElapsedTime(description = "processing ArrayList")
	public ArrayList<Integer> processArray() {
		return processArray(this.al);
	}

	public static ArrayList<Integer> processArray(ArrayList<Integer> m) {
		while (m.size() != 1) {
			for (int i=0; i<m.size(); i=+2) {
				m.remove(i);
			}
		}
		return m;
	}

	@GetElapsedTime(description = "processing LinkedList")
	public LinkedList<Integer> processLinked() {
		return processLinked(this.ll);
	}

	public static LinkedList<Integer> processLinked(LinkedList<Integer> m) {
		while (m.size() != 1) {
			for (int i=0; i<m.size(); i=+2) {
				m.remove(i);
			}
		}
		return m;
	}
}
