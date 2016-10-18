package by.it.savelyeva.matlab;

import by.it.savelyeva.matlab.inout.Parser;
import by.it.savelyeva.matlab.inout.Printer;
import by.it.savelyeva.matlab.vars.Var;

import java.util.*;

public class Calc {

	private static String operation = "";

	private static HashMap<String, Var> hm = new LinkedHashMap<>();

	public static HashMap<String, Var> getCalcMap() {
		return hm;
	}

	public Calc(HashMap<String, Var> hm) {
		this.hm = hm;
	}

	public void printVariables() {
		System.out.println("Print variables:");
		Printer.printData(this.hm.toString());
	}

	public void sortVariables() {
		System.out.println("Sorted variables:");
		SortedSet<String> keys = new TreeSet<>(this.hm.keySet());
		for (String key : keys) {
			String value = this.hm.get(key).toString();
			System.out.printf("%s <-> %s\n", key, value.toString());
		}
	}

    private static void updateHashMap(Map<String, Var> map) {
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			hm.put(key, map.get(key));
		}
	}

	private String getKeynameOfNullValue(Map<String,Var> map) {
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String variableName = it.next();
			if (map.get(variableName) == null) {
				return variableName;
			}
		}
		return "";
	}

	public static String calculate(String expression) throws VarDimensionException {
		String resultStr = "... : Operation is impossible";
		String strReversePolishNotation = Parser.sortingStation(expression, hm);
		updateHashMap(Parser.getStoredVariables());
		Stack<Var> stackVar = new Stack<>();
		String[] parts = strReversePolishNotation.split(" ");
		int i = 0;
		while (i < parts.length) {
			if (!Parser.isSupportedOperation(parts[i])) {
				if (!hm.keySet().contains(parts[i])) {
					if (Parser.isRegexpMatched(parts[i], Parser.patternVariable)) {
						hm.put(parts[i], null);
					} else stackVar.push(Parser.parseOneVar(parts[i]));
				}
				else {
					if (hm.get(parts[i]) != null) {
						stackVar.push(hm.get(parts[i]));
					}
				}
			} else {
				Var rightOperand = stackVar.pop();
				Var leftOperand = stackVar.empty() ? null : stackVar.pop();
				if (leftOperand != null && hm.keySet().contains(leftOperand.toString())) {
					leftOperand = hm.get(leftOperand.toString());
				}
				String leftOperandStr = (leftOperand == null) ? Parser.getKeynameOfNullValue(hm) : leftOperand.toString();
				System.out.printf("%s %s %s ", leftOperandStr , parts[i], rightOperand);
				Var result = null;
				switch (parts[i]) {
					case "*": result = leftOperand.mul(rightOperand); stackVar.push(result); break;
					case "/": result = leftOperand.div(rightOperand); stackVar.push(result); break;
					case "+": result = leftOperand.add(rightOperand); stackVar.push(result); break;
					case "-": result = leftOperand.sub(rightOperand); stackVar.push(result); break;
					case "=": stackVar.push(rightOperand);
							  if (leftOperandStr != "" && Parser.isRegexpMatched(leftOperandStr, Parser.patternVariable)) {
								  hm.put(leftOperandStr, rightOperand);
							  }
							  System.out.printf("%s", "");
							  break;
				}
				if (operation.compareTo("=") != 0) {
					if (result != null) {
						System.out.printf("= %s ", result);
					}
				}
				System.out.println();
			}
			i++;
		}
		if (stackVar.size() != 1) {
			String msg = "Expression syntax Error";
			resultStr = msg;
			throw new IllegalStateException(msg);
		}
		if (stackVar.peek() != null) return stackVar.pop().toString();
		else return resultStr;
	}

	public static Calc restoreCalc(String filename) {
		HashMap<String, Var> hm = Parser.readFile(filename);
		return new Calc(hm);
	}

	public void backupCalc(String filename) {
		(new Printer()).printData(hm, filename);
	}
}
