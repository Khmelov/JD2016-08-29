package by.it.artiuschik.mathlab.vars;

public class VarF extends Var {
    public double value;
    public VarF(double value) {
        this.value = value;
    }
    public VarF(String str)
    {
        setFrom(str);
    }
    @Override
    public void setFrom(String str) {
        if(!str.equals("")) {
            value= Double.parseDouble(str);
        }
    }

    @Override
    public String toString() {
        return ((Double)value).toString();
    }
}

