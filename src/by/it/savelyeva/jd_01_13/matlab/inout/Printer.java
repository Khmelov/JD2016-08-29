package by.it.savelyeva.jd_01_13.matlab.inout;

public class Printer {

	private static void printData(String data, int outmode) {
		switch (outmode) {
			case 1: System.out.print(data); break; //console
			case 2: //TODO: webui
			case 3: //TODO: file
			default:
				System.out.println("Unknown output mode");
		}
	}

	public static void printData(String data) {
		printData(data, 1); // 1 = to console
	}
}
