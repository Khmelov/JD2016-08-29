package by.it.emelyanov.jd01_09.operation;

import by.it.emelyanov.jd01_09.abstraction.Variable;
import by.it.emelyanov.jd01_09.vars.VarF;
import by.it.emelyanov.jd01_09.vars.VarV;


public class VarVOper extends VarV {
    public VarVOper(String str) {
        super(str);
    }

    @Override
    public Variable add(Variable var) {
        if (var instanceof VarV) {
            VarV v1 = new VarV(this);
            VarV v2 = (VarV) var;
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] + v2.vector[i];
            }
            return v1;
        }

        if (var instanceof VarF) {
            VarV v1 = new VarV(this);
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] + v2;
            }
            return v1;
        }
        return super.add(var);
    }

    @Override
    public Variable sub(Variable var) {
        if (var instanceof VarV) {
            VarV v1 = new VarV(this);
            VarV v2 = (VarV) var;
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2.vector[i];
            }
            return v1;
        }

        if (var instanceof VarF) {
            VarV v1 = new VarV(this);
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2;
            }
            return v1;
        }
        return super.sub(var);
    }

    @Override
    public Variable mul(Variable var) {
        if (var instanceof VarV) {
            double f = 0;
            VarV v1 = new VarV(this);
            VarV v2 = (VarV) var;
            for (int i = 0; i < v1.vector.length; i++) {
                f = f + (v1.vector[i] * v2.vector[i]);
            }
            return new VarF(f);
        }
        if (var instanceof VarF) {
            VarV v1 = new VarV(this);
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] * v2;
            }
            return v1;
        }
        return super.mul(var);
    }

    @Override
    public Variable div(Variable var) {
        if (var instanceof VarF) {
            VarV v1 = new VarV(this);
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] / v2;
            }
            return v1;
        }
        return super.div(var);
    }
}
