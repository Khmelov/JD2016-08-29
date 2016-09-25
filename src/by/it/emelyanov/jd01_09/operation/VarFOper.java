package by.it.emelyanov.jd01_09.operation;

import by.it.emelyanov.jd01_09.abstraction.Variable;
import by.it.emelyanov.jd01_09.vars.VarF;


public class VarFOper extends VarF {

    public VarFOper(String str) {
        super(str);
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
        return super.div(this);
    }
}
