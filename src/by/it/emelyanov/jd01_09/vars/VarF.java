package by.it.emelyanov.jd01_09.vars;

import by.it.emelyanov.jd01_09.abstraction.Variable;
import by.it.emelyanov.jd01_09.interfaces.Ivariable;


public class VarF extends Variable implements Ivariable {
    public double value;

    public VarF(double value) {
        this.value = value;
    }

    public VarF(String str) {
        fromStr(str);
    }

    @Override
    public String toString() {
        return ((Double) value).toString();
    }

    @Override
    public void fromStr(String str) {
        value = Double.valueOf(str);
    }

    public double getValue() {
        return value;
    }
}
