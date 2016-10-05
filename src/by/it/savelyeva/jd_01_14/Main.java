package by.it.savelyeva.jd_01_14;
/**
 * Created by nato on 9/30/16.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Task A. Write 20 random numbers to binary file, read them out and calculate average.");
		TaskA myTaskA = new TaskA("randoms.bin");
		ArrayList<Integer> nums = myTaskA.generateArrayList(20);
		File f;
		f = myTaskA.writeArrayListToBinaryFile(nums);
		ArrayList<Integer> list = myTaskA.readNumsFromBinaryFileToArrayList(f);
		double avg = myTaskA.calculateAverage(list);
		System.out.printf("\nAverage = %.2f\n", avg);
		
		System.out.println("Task A (additionally). Put sorted list to file, read and display numbers.");
		Collections.sort(list);
		myTaskA = new TaskA("result.bin");
		f = myTaskA.writeArrayListToBinaryFile(list);
		ArrayList<Integer> resultList = myTaskA.readNumsFromBinaryFileToArrayList(f);
		System.out.println("Sorted list:"); 
		myTaskA.printCollection(resultList);
		System.out.println();
		
		System.out.println("Task B. Count words and punctuation signs from a text stored in the file.");
		TaskB myTaskB = new TaskB("jd_01_14/", "fragment.txt");
		myTaskB.printStatistics();
		System.out.println();
		
		System.out.println("Task C. Display (separately) directories and files from the project structure.");
		TaskC myTaskC = new TaskC();
		myTaskC.printFilesDirsSeparately();
		System.out.println();
	}

}
