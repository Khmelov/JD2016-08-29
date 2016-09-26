package by.it.tsiamruk.matlab.vars;


import by.it.tsiamruk.matlab.Patterns;
import by.it.tsiamruk.matlab.interfaces.IVar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var implements IVar {
    public double[] vector;

    public VarV(String str){
        setFrom(str);
    }

    public VarV(double[] vector) {
        this.vector = new double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    protected VarV(VarV init){
        this.vector = new double[init.vector.length];
    }


    @Override
    public void setFrom(String str) {
        String[] elem = str.split(",");
        vector = new double[elem.length];
        Matcher m = Pattern.compile(Patterns.exVal).matcher(str);
        int i = 0;
        while (m.find()) {
            vector[i]=Double.parseDouble(m.group());
            i++;
        }
    }
}
