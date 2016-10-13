package by.it.savelyeva.matlab.vars;

import by.it.savelyeva.matlab.Error;
import by.it.savelyeva.matlab.VarDimensionException;
import by.it.savelyeva.matlab.interfaces.IOperable;

/**
 * Created by nato on 9/16/16.
 */
public abstract class Var implements IOperable {
    @Override
    public Var add(Var var) throws VarDimensionException {
        new Error("Addition is impossible");
        return null;
    }

    @Override
    public Var sub(Var var) throws VarDimensionException {
        new Error("Substraction is impossible");
        return null;
    }

    @Override
    public Var mul(Var var) throws VarDimensionException {
        new Error("Multiplication is impossible");
        return null;
    }

    @Override
    public Var div(Var var)  throws ArithmeticException {
        new Error("Division is impossible");
        return null;
    }

}
