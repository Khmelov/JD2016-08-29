package by.it.savelyeva.matlab;

import by.it.savelyeva.matlab.inout.Parser;
import by.it.savelyeva.matlab.inout.Printer;
import by.it.savelyeva.matlab.vars.Var;
import by.it.savelyeva.matlab.vars.VarFloat;
import by.it.savelyeva.matlab.vars.VarMatrix;
import by.it.savelyeva.matlab.vars.VarVector;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
	private Var[] operands;
	private String operand;
	private String operation;
	private HashMap<String, Var> hm;

	public Calc() {
		this.operands = new Var[]{null, null, null};
		this.operation = "";
		this.operand = "";
		this.hm = new LinkedHashMap<String, Var>();
	}

	public Calc(HashMap<String, Var> hm) {
		this.operands = new Var[]{null, null, null};
		this.operation = "";
		this.operand = "";
		this.hm = hm;
	}

	public HashMap<String, Var> getHashMap() {
		return this.hm;
	}

	public void printVariables() {
		System.out.println("Print variables:");
		Printer.printData(this.hm.toString());
	}

	public void sortVariables() {
		System.out.println("Sorted variables:");
		SortedSet<String> keys = new TreeSet<String>(this.hm.keySet());
		for (String key : keys) {
			String value = this.hm.get(key).toString();
			System.out.printf("%s <-> %s\n", key, value.toString());
		}
	}

	private void init(String s) {
		Pattern pattern = Pattern.compile(Parser.patternFloat);
		String[] parts = Parser.parseCommand(s);
		this.operation = parts[parts.length - 1];
		int i = 0;
		while (i < 2) { // i<2, i.e. two operands only is possible
			StringBuilder sb = new StringBuilder(parts[i]);
			Matcher matcher = pattern.matcher(sb);
			if (matcher.find()) this.operands[i] = new VarFloat(matcher.group());
			else {
				String[] rows = parts[i].split(Parser.splitterMatrix);
				if (rows.length > 1) this.operands[i] = new VarMatrix(parts[i]);
				else this.operands[i] = new VarVector(parts[i]);
			}
			if (this.operation == "\\=") {
				this.operand = parts[0];
				this.hm.put(this.operand, this.operands[i]);
			}
			i++;
		}
	}

	private Var calculate() throws VarDimensionException {
		Var v1 = this.operands[0];
		Var v2 = this.operands[1];
		String operation = this.operation.replace("\\", "");
		String output = (operation.compareTo("=") != 0 ? v1.toString() : this.operand) + " " + operation + " ";
		Var result;
		switch (operation) {
			case "+":
				result = v1.add(v2);
				break;
			case "-":
				result = v1.sub(v2);
				break;
			case "*":
				result = v1.mul(v2);
				break;
			case "/":
				result = v1.div(v2);
				break;
			case "=":
				result = v2.assign(this.operand);
				break;
			default:
				System.out.println("Wrong operation!");
				return null;
		}
		if (operation.compareTo("=") == 0) output += result.toString();
		else {
			output += v2.toString();
			if (result != null) {
				output += " = " + result.toString();
			}
		}
		Printer.printData(output);
		return result;
	}

	public Var calculate(String s) throws VarDimensionException {
		init(s);
		Var result = calculate();
		System.out.println("\n");
		return result;
	}

	public static Calc restoreCalc(String filename) {
		HashMap<String, Var> hm = Parser.readFile(filename);
		return new Calc(hm);
	}

	public void backupCalc(String filename) {
		(new Printer()).printData(this.hm, filename);
	}
}
