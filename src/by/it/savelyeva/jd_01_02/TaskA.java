package by.it.savelyeva.jd_01_02;

public class TaskA {
	private String shortest;
	private String longest; 
	private float average = 0;
	
	public void findShortestLongestNums(String[] strArray) {
		this.shortest = strArray[0];
		this.longest = strArray[0];

		for (String s: strArray) {
			if (s.length() < this.shortest.length()) {
				this.shortest = s;
			} else if (s.length() > this.longest.length()) {
				this.longest = s;
				}
			}
		System.out.print("The first shortest num is " + this.shortest);
		System.out.println(", its length = " + String.valueOf(this.shortest.length()));
		
		System.out.print("The first longest num is " + this.longest);
		System.out.println(", its length = " + String.valueOf(this.longest.length()));
	}
	
	public void findNumsWithLengthLessAverage(String[] strArray) {
		this.average = Util.countAverage(strArray);
		System.out.print("Nums with length < average (=" + Float.valueOf(this.average) + ") : ");
		for (String s: strArray) {
			if (s.length() < this.average) {
				System.out.print(s + " ");
			} 
		}
		System.out.println();
	}
	
	public void findFirstNumDifferentDigits(String[] strArray) {
		boolean allDigitsDifferent;
		String result = "not found";
		
		for (String s: strArray) {
			allDigitsDifferent = true;
			char[] sArray = s.toCharArray();
			int intArrayTemp[] = new int[10];

			int i = 0;
			if (Integer.parseInt(s) < 0) {
				i = 1;
			}
			for (; i<s.length(); i++) {
				intArrayTemp[Integer.parseInt(sArray[i]+"")]++;
			}
			for (i=0; i<intArrayTemp.length; i++) {
				if (intArrayTemp[i]>1) {
					allDigitsDifferent = false;
				}
			}
            if (allDigitsDifferent) {
            	result = s;
            	break;
            }
		}
		System.out.println("First num comprised of different digits is: " + result);
	}
}
