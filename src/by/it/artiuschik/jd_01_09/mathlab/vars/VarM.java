package by.it.artiuschik.jd_01_09.mathlab.vars;

import by.it.artiuschik.jd_01_09.Error;
import by.it.artiuschik.jd_01_09.mathlab.utils.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarM extends Var {
    public double[][] matrix;

    public VarM(double[][] mas)//? лучше копировать из  mas  в  matrix
    {
        this.matrix = mas;
    }

    public VarM(String str) {
        if (!str.equals("")) {
            setFrom(str);
        } else {
            new Error("В конструктор передана пустая строка!");
        }
    }

    @Override
    public void setFrom(String str) {
        int rows = 0;//количество строк матрицы
        int cols = 0;//число колонок в матрице
        Pattern p = Pattern.compile(Patterns.vector);
        Matcher m = p.matcher(str);
        while (m.find()) {
            rows++;
        }
        String[] strings = new String[rows];
        int count = 0;
        m.reset(str);
        while (m.find()) {
            strings[count] = m.group();
            count++;
        }
        p = Pattern.compile(Patterns.number);
        m = p.matcher(strings[0]);
        while (m.find()) {
            cols++;
        }
        matrix = new double[rows][cols];
        for (int i = 0; i < strings.length; i++) {
            count = 0;
            m = p.matcher(strings[i]);
            while (m.find()) {
                matrix[i][count] = Double.parseDouble(m.group());
                count++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("VarM:\n");
        String prefix;
        if (!(matrix == null)) {
            for (double[] aMatrix : matrix) {
                prefix = "{";
                for (int j = 0; j < matrix[0].length; j++) {
                    res.append(prefix).append(aMatrix[j]);
                    prefix = ",";
                }
                res.append("}\n");
            }
        }
        return res.toString();
    }
}
