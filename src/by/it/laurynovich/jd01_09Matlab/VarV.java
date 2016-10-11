package by.it.laurynovich.jd01_09Matlab;

import java.util.Arrays;

/**
 * Created by vseotdala on 9/16/2016.
 */
import java.util.Arrays;

public class VarV extends Var {
    double[] value;

    public VarV(double[] value) {
        this.value = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = value[i];
        }

    }

    @Override
    public Var add(Var var) {
        if (var instanceof VarF) {
            VarV res = new VarV(value);
            for (int i = 0; i < value.length; i++) {
                res.value[i] = res.value[i] + ((VarF) var).value;
            }
            return res;
        }

        if (var instanceof VarV) {
            VarV res = new VarV(value);
            for (int i = 0; i < value.length; i++) {
                res.value[i] = res.value[i] + ((VarV) var).value[i];
            }
            return res;
        }
        return var.add(this);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarF) {
            VarV res = new VarV(value);
            for (int i = 0; i < value.length; i++) {
                res.value[i] = res.value[i] - ((VarF) var).value;
            }
            return res;
        }

        if (var instanceof VarV) {
            VarV res = new VarV(value);
            for (int i = 0; i < value.length; i++) {
                res.value[i] = res.value[i] - ((VarV) var).value[i];
            }
            return res;
        }
        return var.add(this);
    }

    @Override
    public Var mul(Var var) {
        VarV res = new VarV(value);
        if (var instanceof VarF) {
            for (int i = 0; i < value.length; i++) {
                res.value[i] = res.value[i] * ((VarF) var).value;
            }
        }
        return res;
    }

    @Override
    public Var div(Var var) {
        VarV res = new VarV(value);
        if (var instanceof VarF) {
            for (int i = 0; i < value.length; i++) {
                res.value[i] = res.value[i] / ((VarF) var).value;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
