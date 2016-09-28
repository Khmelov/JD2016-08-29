package by.it.savelyeva.jd_01_09.vars;

import by.it.savelyeva.jd_01_09.interfaces.IVariable;

/**
 * Created by nato on 9/16/16.
 */
public class VarFloat extends Var implements IVariable {

    private double value;

    public VarFloat(double value) {
        this.value = value;
    }

    public VarFloat(String s) {
        this.value = ((VarFloat) fromString(s)).value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public Var add(Var var) {
        if (var instanceof VarFloat) {
            return new VarFloat(this.value + ((VarFloat) var).value);
        }
        return var.add(this);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarFloat) {
            return new VarFloat(this.value - ((VarFloat) var).value);
        }
        VarFloat minus = new VarFloat(-1);
        return (minus.mul(var)).add(this);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarFloat) {
            return new VarFloat(this.value * ((VarFloat) var).value);
        }
        return var.mul(this);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarFloat) {
            return new VarFloat(this.value / ((VarFloat) var).value);
        }
        return super.div(this);
    }

    @Override
    public Var assign(String s) {
        return new VarFloat(this.value);
    }


    @Override
    public String toString() {
        return ((Double) value).toString();
    }

    public String toString(String format) {
        return String.format(format, (Double) this.value);
    }

    @Override
    public Var fromString(String s) {
        return (Var) new VarFloat(Double.parseDouble(s));
    }
}

