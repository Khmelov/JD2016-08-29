package by.it.savelyeva.jd_01_workbook;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task {
	
	public void convertSeconds(int seconds) {
		int sec = seconds % 60;
		int m = (seconds - sec) / 60;
		int min = m % 60;
		int h = (m - min) / 60;
		int hours = h % 24;
		int d = (h - hours) / 24;
		int days = d % 7;
		int weeks = d / 7;
		System.out.println( weeks + " weeks, " + 
							days + " days, " + 
							hours + " hours, " + 
							min + " minutes, " + 
							sec + " seconds");
	}
	
	public boolean checkLastDigitIsGivenValue(int intNumber, int lastDigit) {
		int last = intNumber % 10;
		if (last == lastDigit) return true;
		return false;
	}
	
	public boolean checkRectangleIsCoveredByCircle(int a, int b, int r) {
		if (Math.sqrt(a*a + b*b) <= (2*r)) return true;
		return false;
	}
	
	public String addRoublesToAmount(int amount) {
		int lastDigit = amount % 10;
		String s = " ";
		switch (lastDigit) {
			case 1: s += "рубль"; break;
			case 2:
			case 3: 
			case 4: s += "рубля"; break;
			default:
				 s += "рублей";
		}
		return Integer.toString(amount) + s;
	}
	
	public String printNextDate(int day, int month, int year) {
		Calendar calendar = new GregorianCalendar(year, month, day);
		calendar.add(Calendar.DAY_OF_YEAR, 1); 
		String strDate = "Year: " + calendar.get(Calendar.YEAR) + ", " + 
						 "Month: " + calendar.get(Calendar.MONTH) + ", " + 
						 "Day: " + calendar.get(Calendar.DAY_OF_MONTH);
		return strDate;
	}
	
	public int countFactorial(int num) {
		if (num<0) return -1;
		if (0==num || 1==num) return 1;
		int fact = 1;
		for (int i=2; i<=num; i++) fact *= i;
		return fact;
	}
	
	public int maxElementInArray(int[] intArray) {
		if (intArray.length<1) return Integer.MIN_VALUE;
		int max = intArray[0];
		for (int i=0; i<intArray.length; i++) {
			if (max<intArray[i]) max = intArray[i];
		}
		return max;
	}
	
	public boolean numberIsSimple(int num) {
		if (num<2) return false;
		if (2==num) return true;
		for (int i=2; i<=num/2; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}

	public boolean numberIsSimpleUsingBreak(int num) {
		if (num<2) return false;
		boolean isSimple = true;
		for (int i=2; i<=num/2; i++) {
			if (num % i == 0) {
				isSimple = false;
				break;
			}
		}
		return isSimple;
	}
	
	public int maxElementIndexInArray(int[] intArray) {
		if (intArray.length<1) return Integer.MIN_VALUE;
		int maxIndex = 0;
		for (int i=0; i<intArray.length; i++) {
			if (intArray[maxIndex]<intArray[i]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public void printArray(int[] intArray) {
		String s = "";
		if (0==intArray.length) s = "Array has no elements";
		for (int i=0; i<intArray.length; i++) {
			System.out.printf("%d ", intArray[i]);
		}
		System.out.println(s);
	}
	public int[] revertArray(int[] intArray) {
		for (int i=0; i<intArray.length/2; i++) {
			int tmp = intArray[i];
			intArray[i] = intArray[intArray.length-i-1];
			intArray[intArray.length-i-1] = tmp;
		}
		printArray(intArray);
		return intArray;
	}
}
