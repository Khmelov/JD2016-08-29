package by.it.laurynovich.jd01_09Matlab;

import java.util.Arrays;

/**
 * Created by vseotdala on 9/16/2016.
 */
public class VarM extends Var {
    double [][]value;

    public VarM(double[][] value) {
        this.value = value;
    }

    @Override
    public Var add (Var var) {
        VarM res = new VarM(value);
            if (var instanceof Var) {

                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < value[0].length; j++) {
                        res.value[i][j] = res.value[i][j] + ((VarF) var).value;
                    }
                }
               // return res;
            }
            if (var instanceof VarM) {
                //VarM res = new VarM (value);
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < value[0].length; j++) {
                        res.value[i][j] = res.value[i][j] + ((VarM) var).value[i][j];
                    }
                }
               // return res;
          }
        return res;
    }


//    @Override
//    public Var sub(Var var) {
//        return super.sub(var);
//    }
//
//    @Override
//    public Var mul(Var var) {
//        return super.mul(var);
//    }
//
//    @Override
//    public Var div(Var var) {
//        return super.div(var);
//    }


    @Override
    public String toString() {


        for (int i = 0; i < value.length  ; i++) {

            Arrays.toString(value[i]);

        }
        return toString();
    }

}