package by.it.artiuschik.jd_01_09.mathlab.vars;

public class VarF extends by.it.artiuschik.jd_01_09.mathlab.vars.Var {
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
        return "VarF:\n"+this.value;
    }
}

