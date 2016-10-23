package by.it.emelyanov.jd02_06.mathlab.vars;

import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

public class VarV extends Variable implements Ivariable {
    private double[] vector;

    public VarV(String str) {
        fromStr(str);
    }

    VarV(double[] vector) {
        this.vector = new double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    VarV(VarV init) {
        this.vector = new double[init.vector.length];
        System.arraycopy(init.vector, 0, this.vector, 0, this.vector.length);
    }

    @Override
    public Variable add(Variable var) {
        if (var instanceof VarV)
        {
            VarV v1 = new VarV(this);
            VarV v2 = (VarV) var;
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] + v2.vector[i];
            }
            return v1;
        }
        if (var instanceof VarF)
        {
            VarV v1 = new VarV(this);
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] + v2;
            }
            return v1;
        }
        return super.add(var);
    }

    @Override
    public Variable sub(Variable var) {
        if (var instanceof VarV)
        {
            VarV v1 = new VarV(this);
            VarV v2 = (VarV) var;
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2.vector[i];
            }
            return v1;
        }
        if (var instanceof VarF)
        {
            VarV v1 = new VarV(this);
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2;
            }
            return v1;
        }
        return super.sub(var);
    }

    @Override
    public Variable mul(Variable var) {
        if (var instanceof VarV)
        {
            double f = 0;
            VarV v1 = new VarV(this);
            VarV v2 = (VarV) var;
            for (int i = 0; i < v1.vector.length; i++) {
                f = f + (v1.vector[i] * v2.vector[i]);
            }
            return new VarF(f);
        }
        if (var instanceof VarF)
        {
            VarV v1 = new VarV(this);
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] * v2;
            }
            return v1;
        }
        return super.sub(var);
    }

    @Override
    public Variable div(Variable var) {
        if (var instanceof VarF)
        {
            VarV v1 = new VarV(this);
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] / v2;
            }
            return v1;
        }
        return super.div(var);
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
        Matcher m = compile("-?[0-9.]+").matcher(str);
        int i = 0;
        while (m.find()) {
            vector[i] = Double.parseDouble(m.group());
            i++;
        }
    }
}
