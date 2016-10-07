package by.it.artiuschik.jd_01_09.mathlab.utils;

import by.it.artiuschik.jd_01_09.mathlab.operations.Calculator;
import by.it.artiuschik.jd_01_09.mathlab.vars.Var;

import java.util.*;

public class PrintOperations {
    public static void printvar() {
        HashMap<String, Var> varibles = Calculator.getVaribles();
        for (Map.Entry<String, Var> entry : varibles.entrySet()) {
            String key = entry.getKey();
            Var v = entry.getValue();
            System.out.println(key + "=" + v.toString());
        }
    }

    public static void sortvar() {
        HashMap<String, Var> varibles = Calculator.getVaribles();
        List<String> keys = new ArrayList<>(varibles.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            System.out.println(key + "=" + varibles.get(key));
        }
    }
}
