package by.it.savelyeva.jd_01_02;

import java.util.Scanner;

public class TaskB {
	public static final String[] monthsNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	public String monthName;

	public TaskB() {
		Scanner scanner = new Scanner(System.in);
		int monthNumber = 0;
		do {
			System.out.print("Enter a month number [1-12]: ");
			String monthNumberStr = scanner.nextLine();
			try {
				monthNumber = Integer.parseInt(monthNumberStr); 
			} catch (NumberFormatException e) {
				System.out.println(monthNumberStr + " is a bad choice: " + e);
				break;
			} 
			System.out.println("You selected number of month: " + monthNumberStr);
		} while (monthNumber < 1 && monthNumber > 12);

		try {
			this.monthName = monthsNames[monthNumber-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("there was no valid input for month number");
		}
	}

	public void printSelectedMonth() {
		if (this.monthName == null) {
			System.out.println("Selected month is not detected");
		} else {
			System.out.println("Selected month: " + this.monthName);
		}
	}
	public boolean isNumInRange(int k, int n, int m) {
		if (k>=n && k<=m) {
			System.out.println("k=" + Integer.toString(k) + " belongs to [" + Integer.toString(n) + ", " + Integer.toString(m) + "]");
			return true;
		} else {
			System.out.println("k=" + Integer.toString(k) + " does not belong to [" + Integer.toString(n) + ", " + Integer.toString(m) + "]");
			return false;
		}
	}
	public void printNaturalNumsSquareMatrix(int k) {
		int side = (int) Math.sqrt(k);
		int num = 1;
		for (int i=0; i<side; i++) {
			for (int j=0; j<side; j++) {
				System.out.print(Integer.toString(num++) + " ");
			}
			System.out.println();
		}
	}
	public void solveSquareEquation(int[] args) {
		int a = args[0];
		int b = args[1];
		int c = args[2];
		float D = b*b - 4*a*c;
		System.out.print("Equation " + Integer.toString(a) + "*x^2 + " + Integer.toString(b) + "*x + " + Integer.toString(c) + "=0 ");
		if (D < 0) {
			System.out.println("does not have roots");
		} else if (D == 0){
			System.out.println("has one root: x1,2=" + Float.toString(-b/(2*a)));
		} else {
			double sqrtD = Math.sqrt(D);
			float x1 = (float)(-b + sqrtD)/(2*a);
			float x2 = (float)(-b - sqrtD)/(2*a);
			System.out.println("has two roots: x1=" + Float.toString(x1) + " and x2=" + Float.toString(x2));
		}
	}
}
