package by.it.tsiamruk.matlab.operations;

import by.it.tsiamruk.matlab.interfaces.IAdd;
import by.it.tsiamruk.matlab.interfaces.IDiv;
import by.it.tsiamruk.matlab.interfaces.IMul;
import by.it.tsiamruk.matlab.interfaces.ISub;
import by.it.tsiamruk.matlab.vars.Var;
import by.it.tsiamruk.matlab.vars.VarV;

/**
 * Created by waldemar on 22/09/2016.
 */
public class VarVOperations extends VarV implements IAdd,ISub,IMul,IDiv {

    public VarVOperations(double[] vector) {
        super(vector);
    }

    public VarVOperations(VarV init) {
        super(init);
    }

    public VarVOperations(String str) {
        super(str);
    }

    @Override
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override
    public Var add(Var var) {
        return super.add(var);
    }
}
