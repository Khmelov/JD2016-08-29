package by.it.artiuschik.jd_02_04.mathlab.vars;

import by.it.artiuschik.jd_02_04.mathlab.errors.Error;
import by.it.artiuschik.jd_02_04.mathlab.utils.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var {
    public double[] value;

    public VarV(double[] value) {
        this.value = value;
    }

    public VarV(String str) {
        if (!str.equals("")) {
            setFrom(str);
        } else {
            //new by.it.artiuschik.jd_01_09.mathlab.errors.Error("В конструктор передана пустая строка!");
            new Error("В конструктор передана пустая строка!");
        }
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder("");
        String prefix="{";
        for (Double val:value) {
            res.append(prefix).append(val.toString());
            prefix=", ";
        }
        return res.append("}").toString();
    }

    /*@Override
    public void setFrom(String str) {
        int counter = 0;
        String[] mas = str.split(",");
        value = new double[mas.length];
        Pattern p = Pattern.compile(Patterns.exVal);
        Matcher m = p.matcher(str);
        while (m.find()) {
            value[counter] = Double.parseDouble(m.group());
            counter++;
        }
    }*/
    public void setFrom(String str) {
        String[] elem=str.split(",");
        value=new double[elem.length];
        Matcher m=Pattern.compile(Patterns.exVal).matcher(str);
        int i=0;
        while (m.find()) {
            value[i]=Double.parseDouble(m.group());
            i++;
        }
    }
}

