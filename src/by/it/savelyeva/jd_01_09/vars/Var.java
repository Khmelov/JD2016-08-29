package by.it.savelyeva.jd_01_09.vars;

import by.it.savelyeva.jd_01_09.Error;
import by.it.savelyeva.jd_01_09.interfaces.IOperable;

/**
 * Created by nato on 9/16/16.
 */
public abstract class Var implements IOperable {
    @Override
    public Var add(Var var) {
        new Error("Addition is impossible");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Substraction is impossible");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Multiplication is impossible");
        return null;
    }

    @Override
    public Var div(Var var) {
        new Error("Division is impossible");
        return null;
    }
}
