package by.it.savelyeva.jd_01_02;

import java.util.Random;
import java.util.Scanner;

public class Util {
	public static String[] readFromConsole() {
		//String line = "-21 7 2 567 44 55 -3 88 999";
		System.out.print("Enter space-separated numbers: ");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		System.out.println(line);
		String[] strArray = line.split(" ");
		return strArray;
	}
	public static int[] convertStringsToNums(String[] strArray) {
        int[] result = new int[strArray.length];
		for (int i=0; i<strArray.length; i++) {
			result[i] = Integer.parseInt(strArray[i]);
		}
		return result;
	}
	public static float countAverage(String[] strArray) {
        float result = 0;
		for (int i=0; i<strArray.length; i++) {
			result += strArray[i].length();
		}
		result = result/strArray.length;
		return result;
	}
	public static void printIntArray(int[] intArray) {
        for (int i=0; i<intArray.length; i++) {
			System.out.print(String.valueOf(intArray[i]) + " ");
		}
	}
	public static int[][] buildSquareMatrix() {
		System.out.print("Enter N (size of square matrix): ");
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		int[][] intSquareMatrix = new int[size][size];
		Random randomGenerator = new Random();
	    for (int i=0; i<size; i++){
	    	for (int j=0; j<size; j++) {
	    		int power = randomGenerator.nextInt(2);
	    		intSquareMatrix[i][j] = (int) Math.pow(-1,power) * randomGenerator.nextInt(size+1);
	    		System.out.printf("%d ", intSquareMatrix[i][j]);
	    	}
	    	System.out.println();
	    }
		return intSquareMatrix;
	}
	public static void printSquareMatrix(int[][] matrix) {
		int size = matrix[0].length;
	    for (int i=0; i<size; i++){
	    	for (int j=0; j<size; j++) {
	    		System.out.printf("%d ", matrix[i][j]);
	    	}
	    	System.out.println();
	    }
	}
}
