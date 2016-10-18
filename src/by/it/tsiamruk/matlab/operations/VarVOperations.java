package by.it.tsiamruk.matlab.operations;

import by.it.tsiamruk.matlab.interfaces.IAdd;
import by.it.tsiamruk.matlab.interfaces.IDiv;
import by.it.tsiamruk.matlab.interfaces.IMul;
import by.it.tsiamruk.matlab.interfaces.ISub;
import by.it.tsiamruk.matlab.vars.Var;
import by.it.tsiamruk.matlab.vars.VarF;
import by.it.tsiamruk.matlab.vars.VarM;
import by.it.tsiamruk.matlab.vars.VarV;

/**
 * Created by waldemar on 22/09/2016.
 */
public class VarVOperations extends VarV implements IAdd, IMul, IDiv, ISub {

    public VarVOperations(double[] vector) {
        super(vector);
    }

    public VarVOperations(VarV init) {
        super(init);
    }

    public VarVOperations(String str) {
        super(str);
    }

    @Override
    public double[] getVector() {
        return super.getVector();
    }

    @Override
    public void setFrom(String str) {
        super.setFrom(str);
    }

    //operations
    @Override
    public Var add(Var var) {
        if (var instanceof VarV) {
            VarV v1 = new VarV(this.getVector());
            VarV v2 = (VarV) var;
            for (int i = 0; i < v1.getVector().length; i++) {    //считаем
                v1.getVector()[i] += v2.getVector()[i]; //основная операция
            }
            return v1;
        }
        if (var instanceof VarF) //проверим, является ли аргумент скаляром
        {
            VarV v1 = new VarV(this.getVector());                 //первый операнд
            double v2 = ((VarF) var).getValue();   //второй
            for (int i = 0; i < v1.getVector().length; i++) {    //считаем
                v1.getVector()[i] += v2;           //основная операция
            }
            return v1;                                      //выводим итог
        }
        else
            return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarV) {
            VarV v1 = new VarV(getVector());
            VarV v2 = ((VarV) var);
            for (int i = 0; i < v1.getVector().length; i++) {
                v1.getVector()[i] -= v2.getVector()[i];
            }
            return v1;
        }
        if (var instanceof VarF) {
            VarV v1 = new VarV(getVector());
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.getVector().length; i++) {
                v1.getVector()[i] -= v2;
            }
            return v1;
        }
        else
            return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarV) {
            double f = 0;
            VarV v1 = new VarV(getVector());
            VarV v2 = ((VarV) var);
            for (int i = 0; i < v1.getVector().length; i++) {
                f = f + v1.getVector()[i] * v2.getVector()[i];
            }
            return new VarF(f);
        }
        if (var instanceof VarF) {
            VarV v1 = new VarV(getVector());
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.getVector().length; i++) {
                v1.getVector()[i] *= v2;
            }
            return v1;
        }
        if (var instanceof VarM)
            return new VarMOperations(((VarM) var).getValue()).mul(this);
        else
            return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarF) {
            VarV v1 = new VarV(getVector());
            double v2 = ((VarF) var).getValue();
            for (int i = 0; i < v1.getVector().length; i++) {
                v1.getVector()[i] /= v2;
            }
            return v1;
        } else
            return super.div(var);

    }
}
