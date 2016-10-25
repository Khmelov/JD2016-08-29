package by.it.artiuschik.mathlab.vars;

import by.it.artiuschik.mathlab.errors.Error;
import by.it.artiuschik.mathlab.utils.Patterns;

import java.util.ArrayList;
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
        ArrayList<String> rows = new ArrayList();
        Pattern p = Pattern.compile(Patterns.exVec);
        Matcher m = p.matcher(str);
        while (m.find()) {
            rows.add(m.group());
        }
        matrix = new double[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            String[] elem = rows.get(i).split(",");
            double[] value = new double[elem.length];
            m = Pattern.compile(Patterns.exVal).matcher(rows.get(i));
            int ind = 0;
            while (m.find()) {
                value[ind] = Double.parseDouble(m.group());
                ind++;
            }
            matrix[i] = value;
        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        String prefix;
        if (!(matrix == null)) {
            prefix = "{";
            for (int i = 0; i < matrix.length; i++) {
                res.append(prefix).append(new VarV(matrix[i]).toString());
                prefix = ",";
            }
            res.append("}");
        }
        return res.toString();
    }
}
