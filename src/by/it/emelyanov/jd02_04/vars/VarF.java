package by.it.emelyanov.jd02_04.vars;

public class VarF extends Variable implements Ivariable {
    private double value;

    public VarF(String str) {
        fromStr(str);
    }

    public VarF(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }


    @Override
    public Variable add(Variable var) {
        if (var instanceof VarF)
            return new VarF(this.value + ((VarF) var).value);
        return var.add(this);
    }

    @Override
    public Variable sub(Variable var) {
        if (var instanceof VarF)
            return new VarF(this.value - ((VarF) var).value);
        VarF minus = new VarF(-1);
        return minus.mul(var.sub(this));
    }

    @Override
    public Variable mul(Variable var) {
        if (var instanceof VarF)
            return new VarF(this.value * ((VarF) var).value);
        return var.mul(this);
    }

    @Override
    public Variable div(Variable var) {
        if (var instanceof VarF)
            return new VarF(this.value / ((VarF) var).value);

        return super.div(var);
    }

    @Override
    public String toString() {
        return ((Double) value).toString();
    }

    @Override
    public void fromStr(String str) {
        value = Double.valueOf(str);
    }

}
