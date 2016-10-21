package by.it.tsiamruk.matlab.vars;


import by.it.tsiamruk.matlab.Patterns;
import by.it.tsiamruk.matlab.interfaces.IVar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarM extends Var implements IVar {
    //field
    private double[][] value;

    //constructors
    public VarM(double[][] value) {
        this.value = value;
    }

    public VarM(String str) {
        if (!str.equals(""))
            setFrom(str);
        else
            System.out.println("Пустая строка");
    }

    //getters and setters
    public double[][] getValue() {
        return value;
    }

    public void setValue(double[][] value) {
        this.value = value;
    }

    /**
     * This method will set Matrix from String
     *
     * @param str input string
     */
    @Override
    public void setFrom(String str) {
        ArrayList<String> rows = new ArrayList<>();
        Pattern findRow = Pattern.compile(Patterns.exVec);
        Matcher m = findRow.matcher(str);
        while (m.find())
            rows.add(m.group());
        value = new double[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            String[] elem = rows.get(i).split(",");
            double[] values = new double[elem.length];
            m = Pattern.compile(Patterns.exVal).matcher(rows.get(i));
            int j = 0;
            while (m.find()) {
                values[j] = Double.parseDouble(m.group());
                ++j;
            }
            value[i] = values;
        }
    }

    /**
     * Method return Matrix to string
     *
     * @return Matrix to string
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            res.append(Arrays.toString(value[i]).replace(" ", "").replace("[", "{").replace("]", "}"));
            if (i < value.length - 1) res.append(",");
        }
        res.append("}");
        return res.toString();
    }


}
