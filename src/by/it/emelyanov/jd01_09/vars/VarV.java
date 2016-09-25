package by.it.emelyanov.jd01_09.vars;

import by.it.emelyanov.jd01_09.abstraction.Variable;
import by.it.emelyanov.jd01_09.interfaces.Ivariable;
import by.it.emelyanov.jd01_09.pattern.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VarV extends Variable implements Ivariable {
    public double[] vector;

    public VarV(String str) {
        fromStr(str);
    }

    public VarV(VarV init) {
        this.vector = new double[init.vector.length];
        System.arraycopy(init.vector, 0, this.vector, 0, this.vector.length);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        String prefix = "{";
        for (Double val : vector) {
            res.append(prefix).append(val.toString());
            prefix = ", ";
        }
        return res.append("}").toString();
    }

    @Override
    public void fromStr(String str) {
        String[] elem = str.split(",");
        vector = new double[elem.length];
        Matcher m = Pattern.compile(Patterns.exVal).matcher(str);
        int i = 0;
        while (m.find()) {
            vector[i] = Double.parseDouble(m.group());
            i++;
        }
    }
}
