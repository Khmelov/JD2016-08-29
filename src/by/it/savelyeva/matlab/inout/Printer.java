package by.it.savelyeva.matlab.inout;

import by.it.savelyeva.matlab.vars.Var;

import java.io.*;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;

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

	public static void printData(HashMap<String,Var> hm, String filename) {
		String src = System.getProperty("user.dir").concat("/src/by/it/savelyeva/matlab/");
		Formatter formatter = null;
		Iterator<String> it = hm.keySet().iterator();
		try (PrintWriter printer = new PrintWriter(new FileWriter(src + filename, false))) {
			while (it.hasNext()) {
				String key = it.next();
				Var value = hm.get(key);
				formatter = new Formatter();
				String s = formatter.format("%s <-> %s\n", key, value.toString()).toString();
				printer.append(s);
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		if (formatter != null) formatter.close();
	}

	public static void printData(String data) {
		printData(data, 1); // 1 = to console
	}
}
