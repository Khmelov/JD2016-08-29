package by.it.tsiamruk.matlab.operations;

import by.it.tsiamruk.matlab.interfaces.IAdd;
import by.it.tsiamruk.matlab.interfaces.IDiv;
import by.it.tsiamruk.matlab.interfaces.IMul;
import by.it.tsiamruk.matlab.interfaces.ISub;
import by.it.tsiamruk.matlab.vars.VarV;

/**
 * Created by waldemar on 22/09/2016.
 */
public class VarVOperations extends VarV implements IAdd,ISub,IMul,IDiv {

    public VarVOperations(double[] value) {
        super(value);
    }
}
