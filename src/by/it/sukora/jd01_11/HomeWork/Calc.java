package by.it.sukora.jd01_11.HomeWork;

import jd01_11.HomeWork.inout.Parser;
import jd01_11.HomeWork.inout.Printer;
import jd01_11.HomeWork.vars.Var;
import jd01_11.HomeWork.vars.VarFloat;
import jd01_11.HomeWork.vars.VarMatrix;
import jd01_11.HomeWork.vars.VarVector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
	private Var[] operands;
	private String operation;

	public Calc() {
		this.operands = new Var[] {null, null, null};
		this.operation = "";
	}

	private void init(String s) {
		Pattern pattern = Pattern.compile(Parser.patternFloat);
		String[] parts = Parser.parseCommand(s);
		this.operation = parts[parts.length-1];
		for (int i=0; i<2; i++) { // i<2, i.e. two operands only is possible
			StringBuilder sb = new StringBuilder(parts[i]);
			Matcher matcher = pattern.matcher(sb);
			if (matcher.find()) this.operands[i] = new VarFloat(matcher.group());
			else {
				String[] rows = parts[i].split(Parser.splitterMatrix);
				if (rows.length > 1) this.operands[i] = new VarMatrix(parts[i]);
				else this.operands[i] = new VarVector(parts[i]);
			}
		}
	}

	private Var calculate() {
		Var v1 = this.operands[0];
		Var v2 = this.operands[1];
		String operation = this.operation.replace("\\","");
		String output = v1.toString() + " " + operation + " " + v2.toString();
		Var result;
		switch (operation) {
			case "+": result = v1.add(v2); break;
			case "-": result = v1.sub(v2); break;
			case "*": result = v1.mul(v2); break;
			case "/": result = v1.div(v2); break;
			default:
				System.out.println("Wrong operation!");
				return null;
		}
		if (result != null) output += " = " + result.toString();
		Printer.printData(output);
		return result;
	}

	public Var calculate(String s) {
		init(s);
		Var result = calculate();
		System.out.println("\n");
		return result;
	}
}
