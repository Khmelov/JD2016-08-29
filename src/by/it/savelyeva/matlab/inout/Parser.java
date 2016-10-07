package by.it.savelyeva.matlab.inout;

import by.it.savelyeva.matlab.Calc;
import by.it.savelyeva.matlab.vars.Var;
import by.it.savelyeva.matlab.vars.VarFloat;
import by.it.savelyeva.matlab.vars.VarMatrix;
import by.it.savelyeva.matlab.vars.VarVector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
				case "printvar": c.printVariables(); c.backupCalc("backup.txt"); break;
				case "sortvar": c.sortVariables(); break;
				case "END": return true;
				default:
					System.out.println("Wrong command! Supported: printvar, sortvar; END to exit");
			}
		}
		return false;
	}

	private static Var parseToVar(String s) {
		Var var = null;
		Pattern pattern = Pattern.compile(Parser.patternFloat);
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) var = new VarFloat(matcher.group());
		else {
			String[] rows = s.split(Parser.splitterMatrix);
			if (rows.length > 1) var = new VarMatrix(s);
			else var = new VarVector(s);
		}
		return var;
	}

	public static HashMap<String, Var> readFile(String filename) {
		String src = System.getProperty("user.dir").concat("/src/by/it/savelyeva/matlab/");
		filename = src + filename;
		HashMap<String, Var> hm = new HashMap<String,Var>();
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = bufferReader.readLine()) != null) {
				String[] parts = line.replaceAll(" ", "").split("<->");
				hm.put(parts[0], parseToVar(parts[1]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return hm;
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(hm);
		return hm;
	}

}
