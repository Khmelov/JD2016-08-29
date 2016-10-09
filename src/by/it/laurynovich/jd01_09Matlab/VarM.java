package by.it.laurynovich.jd01_09Matlab;

import java.util.Arrays;

/**
 * Created by vseotdala on 9/16/2016.
 */
public class VarM extends Var {
    double[][] value;

    public VarM(double[][] value) {
        this.value = value;
    }

    @Override
    public Var add(Var var) {
        VarM res = new VarM(value);
        if (var instanceof VarF) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res.value[i][j] = res.value[i][j] + ((VarF) var).value;
                }
            }
        } else {

            if (var instanceof VarM) {

                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < ((VarM) var).value.length; j++) {
                        res.value[i][j] = res.value[i][j] + ((VarM) var).value[i][j];
                    }
                }
            }
        }
        return res;
    }


//    public Var add1 (Var var){
//        VarM res = new VarM(value);
//        if (var instanceof VarM) {
//
//            for (int i = 0; i < value.length; i++) {
//                for (int j = 0; j < ((VarM) var).value.length; j++) {
//                    res.value[i][j] = res.value[i][j] +  ((VarM) var).value[i][j];
//                }
//            }
//        }
//        return res;
//    }


    @Override
    public Var sub(Var var) {
        VarM res = new VarM(value);
        if (var instanceof VarM) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((VarM) var).value.length; j++) {
                    res.value[i][j] = res.value[i][j] - ((VarM) var).value[i][j];
                }
            }
            return res;
        }
        if (var instanceof VarF) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res.value[i][j] = res.value[i][j] - ((VarF) var).value;
                }
            }
            return res;
        }
        return var.sub(this);
    }


    @Override
    public Var mul(Var var) {
        VarM res = new VarM(value);
        for (int i = 0; i <value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                for (int k = 0; k < value.length ; k++) {
                    res.value[i][j] +=  ((VarM)var).value[j][k] * res.value[k][j];
                }
            }
        }
        return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        VarM res = new VarM(value);
        if (var instanceof VarF) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res.value[i][j] = res.value[i][j] / ((VarF) var).value;
                }
            }
            return res;
        }
        return super.div(var);
    }


    @Override
    public String toString() {

        String res = "";
        for (int i = 0; i < value.length; i++) {

            res = res + Arrays.toString(value[i]);
        }
        return res;
    }
}