package by.it.tsiamruk.matlab.operations;

import by.it.tsiamruk.matlab.interfaces.IAdd;
import by.it.tsiamruk.matlab.interfaces.IDiv;
import by.it.tsiamruk.matlab.interfaces.IMul;
import by.it.tsiamruk.matlab.interfaces.ISub;
import by.it.tsiamruk.matlab.vars.Var;
import by.it.tsiamruk.matlab.vars.VarF;

/**
 * Created by waldemar on 21/09/2016.
 */
public class VarFOperations extends VarF implements IAdd,IDiv,IMul,ISub {

    //constuctors to get a Var value.
    public VarFOperations(String str) {
        super(str);
    }

    public VarFOperations(double value) {
        super(value);
    }

    //calcalation operations
    @Override
    public Var add(Var var) {
        if (var instanceof VarF)
            return new VarF(value + ((VarF)var).value);
        return var.add(this);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarF)
            return new VarF(value / ((VarF)var).value);
        return var.div(this);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarF)
            return new VarF(value * ((VarF) var).value);
        return var.mul(this);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarF)
            return new VarF(value - ((VarF) var).value);
        VarF minus = new VarF(-1);
        return minus.mul(var.sub(this));
    }

}
