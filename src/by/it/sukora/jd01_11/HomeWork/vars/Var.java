package by.it.sukora.jd01_11.HomeWork.vars;

import jd01_11.HomeWork.interfaces.IOperable;


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
