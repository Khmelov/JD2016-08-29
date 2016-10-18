package by.it.tsiamruk.matlab.operations;

import by.it.tsiamruk.matlab.interfaces.IAdd;
import by.it.tsiamruk.matlab.interfaces.IDiv;
import by.it.tsiamruk.matlab.interfaces.IMul;
import by.it.tsiamruk.matlab.interfaces.ISub;
import by.it.tsiamruk.matlab.vars.*;


/**
 * Created by waldemar on 17/10/2016.
 */
public class VarMOperations extends VarM implements IAdd, ISub, IMul, IDiv {
    //constructors
    public VarMOperations(double[][] value) {
        super(value);
    }

    public VarMOperations(String str) {
        super(str);
    }


    /**
     * This method adding some var(float or another matrix) to this matrix.
     *
     * @param var variable for adding.
     * @return matrix, if operation is impossible, returns that string(Operation is impossible).
     * @this our matrix.
     */
    @Override
    public Var add(Var var) {
        if (var instanceof VarF) {
            VarM res = new VarM(this.getValue());
            for (int i = 0; i < res.getValue().length; i++) {
                for (int j = 0; j < res.getValue()[0].length; j++) {
                    res.getValue()[i][j] += ((VarF) var).getValue();
                }
            }
            return res;
        } else if (var instanceof VarM) {
            if (((VarM) var).getValue().length != this.getValue().length &&
                    ((VarM) var).getValue()[0].length != this.getValue()[0].length)
                throw new ArrayIndexOutOfBoundsException();
            VarM res = new VarM(this.getValue());
            for (int i = 0; i < res.getValue().length; i++) {
                for (int j = 0; j < res.getValue()[0].length; j++) {
                    res.getValue()[i][j] += ((VarM) var).getValue()[i][j];
                }
            }
            return res;
        } else
            return super.add(var);
    }

    /**
     * This method subtracting some var(float or another matrix) to this matrix.
     *
     * @param var variable for subtracting
     * @return matrix, or exception.
     */
    @Override
    public Var sub(Var var) {
        if (var instanceof VarF) {
            VarM res = new VarM(this.getValue());
            for (int i = 0; i < res.getValue().length; i++) {
                for (int j = 0; j < res.getValue()[0].length; j++) {
                    res.getValue()[i][j] -= ((VarF) var).getValue();
                }
            }
            return res;
        } else if (var instanceof VarM) {
            if (((VarM) var).getValue().length != this.getValue().length &&
                    ((VarM) var).getValue()[0].length != this.getValue()[0].length)
                throw new ArrayIndexOutOfBoundsException();
            VarM res = new VarM(this.getValue());
            for (int i = 0; i < res.getValue().length; i++) {
                for (int j = 0; j < res.getValue()[0].length; j++) {
                    res.getValue()[i][j] -= ((VarM) var).getValue()[i][j];
                }
            }
            return res;
        }
        return super.sub(var);
    }

    /**
     * This method for multiplication of this matrix and some var(float or another matrix)
     *
     * @param var variable for multiplication
     * @return matrix, or exception.
     */
    @Override
    public Var mul(Var var) {
        if (var instanceof VarF) {
            VarM res = new VarM(this.getValue());
            for (int i = 0; i < res.getValue().length; i++) {
                for (int j = 0; j < res.getValue()[0].length; j++) {
                    res.getValue()[i][j] += ((VarF) var).getValue();
                }
            }
            return res;
        } else if (var instanceof VarV) {
            if (this.getValue()[0].length != ((VarV) var).getVector().length)
                throw new ArrayIndexOutOfBoundsException();
            double[] len = new double[this.getValue().length];
            VarV res = new VarV(len);
            for (int i = 0; i < this.getValue().length; i++) {
                for (int j = 0; j < this.getValue()[0].length; j++) {
                    res.getVector()[i] *= this.getValue()[i][j] + ((VarV) var).getVector()[i];
                }
            }
            return res;
        } else if (var instanceof VarM) {
            if (this.getValue().length != ((VarM) var).getValue().length &&
                    this.getValue()[0].length != ((VarM) var).getValue()[0].length)
                throw new ArrayIndexOutOfBoundsException();
            double[][] len = new double[((VarM) var).getValue().length][((VarM) var).getValue()[0].length];
            VarM res = new VarM(len);
            for (int i = 0; i < len.length; i++) {
                for (int j = 0; j < len[0].length; j++) {
                    for (int k = 0; k < ((VarM) var).getValue()[0].length; k++) {
                        res.getValue()[i][j] += this.getValue()[i][k] * ((VarM) var).getValue()[k][j];
                    }
                }
            }
            return res;
        }
        return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarF) {
            VarM res = new VarM(this.getValue());
            for (int i = 0; i < res.getValue().length; i++) {
                for (int j = 0; j < res.getValue()[0].length; j++) {
                    res.getValue()[i][j] /= ((VarF) var).getValue();
                }
            }
            return res;
        } else
            return super.div(this);
    }
}
