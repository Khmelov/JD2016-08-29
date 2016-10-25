package by.it.tsiamruk.matlab.vars;


import by.it.tsiamruk.matlab.Patterns;
import by.it.tsiamruk.matlab.interfaces.IVar;
import by.it.tsiamruk.matlab.operations.VarVOperations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var implements IVar {
    private double[] vector;

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public VarV(String str) {
        setFrom(str);
    }

    public VarV(double[] vector) {
        this.vector = new double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    public VarV(VarV init) {
        this.vector = new double[init.vector.length];
    }

    public double[] getVector() {
        return vector;
    }

    @Override
    public Var add(Var var) {
        return new VarVOperations(getVector()).add(var);
    }

    @Override
    public Var sub(Var var) {
        return new VarVOperations(getVector()).sub(var);
    }

    @Override
    public Var mul(Var var) {
        return new VarVOperations(getVector()).mul(var);
    }

    @Override
    public Var div(Var var) {
        return new VarVOperations(getVector()).div(var);
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
    public void setFrom(String str) {
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
