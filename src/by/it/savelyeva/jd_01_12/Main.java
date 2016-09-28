package by.it.savelyeva.jd_01_12;

/**
 * Created by nato on 9/28/16.
 */

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Demo for:
		// - custom annotation GetElapsedTime
		// - timings of creation and navigation for different maps types
		Benchmark<Integer> objInteger = new Benchmark<>();
		Benchmark.invokeThis(objInteger);

		Benchmark<Double> objDouble = new Benchmark<>();
		Benchmark.invokeThis(objDouble);


		// Task A1
		System.out.println("\nTask A1: Create ArrayList w/ random marks (1-10), print all marks and then only good marks (>3).");
		TaskA1 myTaskA1 = new TaskA1();
		myTaskA1.printAllMarks(); // will print elements using own interface Iterable<T> and the class MyIterator
		myTaskA1.printGoodMarks();
		myTaskA1.printGoodMarksRetained();

		// Task A2
		System.out.println("\nTask A2: For 2 given sets print their cross and union.");
		Set<Integer> am = Util.generateSetInteger();
		Set<Integer> bm = Util.generateSetInteger();
		TaskA2.printCross(am, bm);
		TaskA2.printUnion(am, bm);

		// Task A3
		System.out.println("\nTask A3: Sort array: positives first, negatives last. Do not use variables swap.");
		ArrayList<Integer> m = Util.generateArrayListInteger();
		System.out.println("Before sort:");
		Util.printIterableCollection(m); //or: Util.printCollection(m);
		m.sort(new TaskA3Comparator<Integer>());
		System.out.println("Sorted (positives first, negatives last):");
		Util.printIterableCollection(m); //or: Util.printCollection(m);

		// Task B1
		System.out.println("\nTask B1: Display all different words from given text and their frequency. Use HashMap.");
		StringBuilder sb = new StringBuilder(Data.novell);
		TaskB1.printWordsStatistics(sb);
		
		// Task B2
		System.out.println("\nTask B2: In ArrayList and LinkedList remove each 2nd element until 1 remains. Compare time.");
		Timer myTimer;
		ArrayList<Integer> a = TaskB2.generateArrayListInteger(1000);
		LinkedList<Integer> b = TaskB2.generateLinkedListInteger(1000);
		myTimer = new Timer(); 
		TaskB2.processArray(a);
		System.out.println(myTimer + " (processArray)");
		myTimer = new Timer();
		TaskB2.processLinked(b);
		System.out.println(myTimer + " (processLinked)");

		TaskB2 myTaskB2 = new TaskB2(); // TaskB alternative solution - using annotation
		Benchmark.invokeThis(myTaskB2);

		// Task C1
		System.out.println("\nTask C1: Split text to words, sort by their hashes, exclude repeated elements.");
		Comparator<String> c = new TaskC1Comparator<String>();
		ArrayList<String> C1 = TaskC1.textToArrayList("a ab c ab a ac");
		Util.printIterableCollection(C1); // or: Util.printCollection(C1);
		C1.sort(c);
		System.out.println("Sorted by hashes: "); Util.printCollectionWithHashes(C1);
		Set<String> C2 = TaskC1.removeRepeated(C1, c);
		System.out.println("Repeated removed: "); Util.printCollectionWithHashes(C2);
		
		// Task C2
		System.out.println("\nTask C2: For 2 given sets print their cross and union.");
		MySet res;
		Set<Integer> intSet1 = new HashSet<Integer>(); intSet1.add(-1); intSet1.add(2); intSet1.add(15);
		Set<Integer> intSet2 = new HashSet<Integer>(); intSet2.add(-1); intSet2.add(-2); intSet2.add(2);
		res = new MySet<Set<Integer>>(intSet1, intSet2);
		res.printCross();
		res.printUnion();
		
		Set<Double> doubleSet1 = new HashSet<Double>(); doubleSet1.add(0.1); doubleSet1.add(0.5); doubleSet1.add(10.0);
		Set<Double> doubleSet2 = new HashSet<Double>(); doubleSet2.add(0.5); doubleSet2.add(0.1); doubleSet2.add(Math.PI);
		res = new MySet<Set<Double>>(doubleSet1, doubleSet2);
		res.printCross();
		res.printUnion();	
		
		Set<String> strSet1 = new HashSet<String>(); strSet1.add("a"); strSet1.add("ab"); strSet1.add("c");
		Set<String> strSet2 = new HashSet<String>(); strSet2.add("a"); strSet2.add("df"); strSet2.add("c1");
		res = new MySet<Set<String>>(strSet1, strSet2);
		res.printCross();
		res.printUnion();
		
		// Task C3
		System.out.println("\nTask C3: Verify positions of brackets, parenthises, braces in a string.");
		String inputString = "\"a{ss[d]efg}([a])w\"";
		StringBuilder s = new StringBuilder(inputString);
		System.out.println("Brackets/parenthises/braces are set " 
							+ (TaskC3.validate(s) ? "correctly" : "incorrectly") 
							+ " in " + inputString);
	}
}
