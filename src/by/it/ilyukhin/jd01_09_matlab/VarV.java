package by.it.ilyukhin.jd01_09_matlab;


import java.util.Arrays;

public class VarV extends Var {
    double[] value;

    public VarV(double[] value) {
        this.value = value;
    }

    @Override
    public Var add(Var var) {
        if (var instanceof VarF) {
            VarV resAdd = new VarV(value);
            for (int i = 0; i < value.length; i++) {
                resAdd.value[i] = resAdd.value[i] + ((VarF) var).valueF;

            }
            return resAdd;
        }
        if (var instanceof VarV) {
            VarV resAdd = new VarV(value);
            for (int i = 0; i < value.length; i++) {
                resAdd.value[i] = resAdd.value[i] + ((VarV) var).value[i];

            }
            return resAdd;
        }

        return var.add(this);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarF) {
            VarV resSub = new VarV(value);
            for (int i = 0; i < value.length; i++) {
                resSub.value[i] = resSub.value[i] -((VarF) var).valueF;

            }
            return resSub;
        }

        if (var instanceof VarV) {
            VarV resSub =new VarV(value);
            for (int i = 0; i < value.length ; i++) {
                resSub.value[i]= resSub.value[i]-((VarV) var).value[i];

            }
            return resSub;
        }

        return var.sub(this);
    }

        @Override
        public String toString () {
            return Arrays.toString(value);
        }
    }

