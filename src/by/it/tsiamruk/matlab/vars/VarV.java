package by.it.tsiamruk.matlab.vars;


import by.it.tsiamruk.matlab.interfaces.IVar;

public class VarV extends Var implements IVar{
    public double[] vector;

    public VarV(double[] value) {
        this.vector = value;
    }


    @Override
    public void setFrom(String str) {

    }
}
