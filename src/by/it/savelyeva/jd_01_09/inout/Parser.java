package by.it.savelyeva.jd_01_09.inout;

import by.it.savelyeva.jd_01_09.Calc;

import java.util.Scanner;

public class Parser {
	public static final String patternFloat = "^[-]?[0-9]*[.]?[0-9]*$";
	public static final String splitterVector = ",";
	public static final String splitterMatrix = "[\\]}]{1}[,]{1}[{\\[]{1}";
	public static final String[] supportedOperations = {"\\+", "\\*", "/", "\\=", "\\-"};

	public static String[] parseCommand(String s) {
		String[] result = new String[3];
		for (int i=0; i<supportedOperations.length; i++) {
			String[] parts = s.split(supportedOperations[i]);
			if (parts.length == 2) {
				result[0] = parts[0];
				result[1] = parts[1];
				result[2] = supportedOperations[i];
				break;
			} else if (parts.length > 2) {
				result[0] = "-" + parts[1]; // here parts[0] is ""
				result[1] = parts[2];
				result[2] = supportedOperations[i];
				break;
			}
		}
		return result;
	}

	private static String readConsoleCommand() {
		return new Scanner(System.in).nextLine();
	}

	public static boolean parseConsoleCommand(Calc c) {
		String line = "";
		while (line != "END") {
			System.out.print("Enter command (printvar or sortvar; END to exit): ");
			line = readConsoleCommand();
			switch (line) {
				case "printvar": c.printVariables(); break;
				case "sortvar": c.sortVariables(); break;
				case "END": return true;
				default:
					System.out.println("Wrong command! Supported: printvar, sortvar; END to exit");
			}
		}
		return false;
	}

}
