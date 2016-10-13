package by.it.artiuschik.jd_01_09.mathlab.vars;

import by.it.artiuschik.jd_01_09.Error;
import by.it.artiuschik.jd_01_09.mathlab.utils.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends by.it.artiuschik.jd_01_09.mathlab.vars.Var {
    public double[] value;

    public VarV(double[] value) {
        this.value = value;
    }

    public VarV(String str) {
        if (!str.equals("")) {
            setFrom(str);
        } else {
            //new by.it.artiuschik.jd_01_09.Error("В конструктор передана пустая строка!");
            new Error("В конструктор передана пустая строка!");
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("VarV:\n");
        String prefix = "{";
        for (double aValue : value) {
            res.append(prefix).append(aValue);
            prefix = ", ";
        }
        return res.append("}").toString();
    }

    @Override
    public void setFrom(String str) {
        int counter = 0;
        String[] mas = str.split(",");
        value = new double[mas.length];
        Pattern p = Pattern.compile(Patterns.number);
        Matcher m = p.matcher(str);
        while (m.find()) {
            value[counter] = Double.parseDouble(m.group());
            counter++;
        }
    }


}
