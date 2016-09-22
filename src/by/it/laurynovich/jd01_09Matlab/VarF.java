package by.it.laurynovich.jd01_09Matlab;

/**
 * Created by vseotdala on 9/16/2016.
 */
public class VarF extends Var{
    public double value;

    public VarF(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.value+((VarF) var).value);
        }

        return var.add(this);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.value-((VarF) var).value);
        }
        VarF minus=new VarF(-1);
        return (minus.mul(var)).add(this);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.value*((VarF) var).value);
        }
        return var.mul(this);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.value/((VarF) var).value);
        }
        return super.div(this);
    }

    @Override
    public String toString() {
        return ((Double)value).toString();
    }
}
