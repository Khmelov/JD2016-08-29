package by.it.ilyukhin.jd01_09_matlab;


public class VarF extends Var {
    public double valueF;

    public VarF(double value) {
        this.valueF = value;
    }

    @Override
    public Var add(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.valueF + ((VarF) var).valueF);
        }


        return var.add(this);
    }

    @Override
    public Var sub(Var var) {

        if (var instanceof VarF) {
            return new VarF(this.valueF - ((VarF) var).valueF);
        }
        //VarF minus = new VarF(-1);
        //return minus.mul(var.sub(this));
        return var.sub(this);


    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.valueF * ((VarF) var).valueF);
        }


        return var.mul(this);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.valueF / ((VarF) var).valueF);
        }


        return super.div(this);
    }

    @Override
    public String toString() {
        return ((Double) valueF).toString();
    }
}
