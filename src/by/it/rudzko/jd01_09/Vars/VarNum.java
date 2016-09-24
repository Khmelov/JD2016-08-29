package by.it.rudzko.jd01_09.Vars;

/**
 * Created by Leta on 23.09.2016.
 */
public class VarNum extends Var {

    public double num;

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
