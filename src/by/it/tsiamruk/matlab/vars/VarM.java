package by.it.tsiamruk.matlab.vars;


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
        this.value = ((VarM) setFromString(str)).getValue();
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
    public Var setFromString(String str) {
        //разбиваю на строку на "ряды массива"
        Pattern rows = Pattern.compile("([0-9].?[0-9]*,?)+");
        Matcher matchRows = rows.matcher(str);
        ArrayList<String> row = new ArrayList<>();
        while (matchRows.find()) {
            row.add(matchRows.group());
        }
        //иницализация будущей матрицы
        double[][] result = new double[row.size()][(row.get(0)).split(",").length];
        //regex для поиска чисел в строке
        Pattern pattern = Pattern.compile("^[-]?[0-9]*[.]?[0-9]*$");
        Matcher matcher;
        for (int i = 0; i < row.size(); i++) {
            String[] elements = row.get(i).split(",");
            for (int j = 0; j < elements.length; j++) {
                StringBuilder sb = new StringBuilder(elements[j]);
                matcher = pattern.matcher(sb);
                if (matcher.find()) {
                    result[i][j] = Double.parseDouble(matcher.group());
                }
            }
        }
        return new VarM(result);
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
            res.append(Arrays.toString(value[i]).replace(" ", ""));
            if (i < value.length - 1) res.append(",");
        }
        res.append("}");
        return res.toString();
    }

    @Override
    public void setFrom(String str) {

    }
}
