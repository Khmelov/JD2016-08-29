package by.it.tsiamruk.matlab.operations;

import by.it.tsiamruk.matlab.interfaces.IAdd;
import by.it.tsiamruk.matlab.interfaces.IDiv;
import by.it.tsiamruk.matlab.interfaces.IMul;
import by.it.tsiamruk.matlab.interfaces.ISub;
import by.it.tsiamruk.matlab.vars.Var;
import by.it.tsiamruk.matlab.vars.VarF;
import by.it.tsiamruk.matlab.vars.VarM;
import by.it.tsiamruk.matlab.vars.VarV;

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

    @Override
    public double getValue() {
        return super.getValue();
    }

    //calcalation operations
    @Override
    public Var add(Var var) {
        if (var instanceof VarF)
            return new VarF(getValue() + ((VarF) var).getValue());
        if (var instanceof VarV) {
            double v1 = getValue();
            VarV v2 = new VarV(((VarV) var).getVector());
            for (int i = 0; i < v2.getVector().length; i++) {
                v2.getVector()[i] += v1;
            }
            return v2;
        }
        if (var instanceof VarM) {
            return new VarMOperations(((VarM) var).getValue()).add(this);
        } else
            return var.add(this);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarF)
            return new VarF(getValue() / ((VarF) var).getValue());
        return var.div(this);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarF)
            return new VarF(getValue() * ((VarF) var).getValue());
        if (var instanceof VarV) {
            VarV v1 = new VarV(((VarV) var).getVector());
            double v2 = getValue();
            for (int i = 0; i < v1.getVector().length; i++) {
                v1.getVector()[i] *= v2;
            }
            return v1;
        }
        if (var instanceof VarM)
            return new VarMOperations(((VarM) var).getValue()).mul(this);
        else
            return var.mul(this);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarF)
            return new VarF(getValue() - ((VarF) var).getValue());

        if (var instanceof VarV) {
            VarV v1 = new VarV(((VarV) var).getVector());
            double v2 = getValue();
            for (int i = 0; i < v1.getVector().length; i++) {
                v1.getVector()[i] -= v2;
            }
            return v1;
        }
        if (var instanceof VarM)
            return new VarMOperations(((VarM) var).getValue()).sub(this);
        else {
            VarF minus = new VarF(-1);
            return minus.mul(var.sub(this));
        }
    }

}
