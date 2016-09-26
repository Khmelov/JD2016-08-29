package by.it.tsiamruk.matlab.vars;


import by.it.tsiamruk.matlab.interfaces.*;

public class VarF extends Var implements IVar{
    private double value;

    /**
     * At first i must create a constructor to get values.
     */
    //get value from string
    public VarF(String str){
        setFrom(str);
    }
    //get value from another double
    public VarF(double value){
        this.value = value;
    }
    //getter for our double
    public double getValue() {
        return value;
    }

    @Override
    public void setFrom(String str) {
        value = Double.valueOf(str);
    }

    @Override
    public String toString(){
        return ((Double)value).toString();
    }


}

