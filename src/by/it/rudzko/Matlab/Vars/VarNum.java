package by.it.rudzko.Matlab.Vars;

import by.it.rudzko.Matlab.Interfaces.IVar;

public class VarNum implements IVar {

    private double num;

    public VarNum(String str) {
        setFrom(str);
    }

    public VarNum(double value) {
        this.num = value;
    }

    public double toNum(){
        return num;
    }

    @Override
    public String toString() {
        return ((Double)num).toString();
    }

    @Override
    public void setFrom(String str) {
        num=Double.valueOf(str);
    }
}
