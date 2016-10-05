package by.it.savelyeva.jd_01_13.matlab.vars;

import by.it.savelyeva.jd_01_13.matlab.Error;
import by.it.savelyeva.jd_01_13.matlab.VarDimensionException;
import by.it.savelyeva.jd_01_13.matlab.interfaces.IOperable;

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

    @Override
    public Var assign(String s) {
        new Error("Assignment is impossible");
        return null;
    }
}
