package by.it.savelyeva.jd_01_15;
/**
 * Created by nato on 9/30/16.
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Task A: create 4x4-matrix of ints [-15,15], print it to console & txt-file, use formatting.");
		TaskA myTaskA = new TaskA(4, -15, 15);
		myTaskA.fillMatrix();
		myTaskA.printMatrix();
		myTaskA.printMatrix("matrix.txt");

		System.out.println("Task B (see TaskBMain): read java file contents, remove all comments, save to txt-file.");

		System.out.println("Task C: create analogue of cmd-line tool which supports 'dir' and 'cd'. Use class File().");
		TaskC myTaskC = new TaskC();
		myTaskC.cmdDirCd();
		
		

	}

}
