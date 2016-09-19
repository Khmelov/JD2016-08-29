package by.it.tsydzik.jd01_09;

import java.util.Arrays;

/**
 * @author Eugene Tsydzik
 * @since 9/19/16.
 */
public class VarV extends Var {
    double[] value;

    public VarV(double[] value) {
        this.value = value;
    }

    @Override
    public Var add(Var var) {
        if (var instanceof VarF) {
            VarV res = new VarV(value);
            for (int i=0; i<value.length; i++) {
                res.value[i] = res.value[i] + ((VarF) var).value;
            }
            return res;
        }
        else if (var instanceof VarV) {
            VarV res = new VarV(value);
            for (int i=0; i<value.length; i++) {
                res.value[i] = res.value[i] + ((VarV) var).value[i];
            }
            return res;
        }
        else return var.add(this);
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
