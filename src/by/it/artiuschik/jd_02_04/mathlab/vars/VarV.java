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

    public void setFrom(String str) {
        String[] coords=str.split(",");
        int coordsAmount=coords.length;
        value=new double[coordsAmount];
        Matcher m=Pattern.compile(Patterns.exVal).matcher(str);
        int i=0;
        while (m.find()) {
            value[i]=Double.parseDouble(m.group());
            i++;
        }
    }
}

