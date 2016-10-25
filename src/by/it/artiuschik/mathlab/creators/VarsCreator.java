package by.it.artiuschik.mathlab.creators;

import by.it.artiuschik.mathlab.utils.Patterns;
import by.it.artiuschik.mathlab.vars.*;

public class VarsCreator {

    public Var createVar(Object param) {//factory method
        Var var;
        if (!(param instanceof String)) //если передана не строка
        {
            if (param instanceof double[]) {
                var = new VarV((double[]) param);//вектор
            } else {
                if (param instanceof double[][]) {
                    var = new VarM((double[][]) param);//матрица
                } else {
                    if (param instanceof Double) {
                        var = new VarF((Double) param);
                    } else {
                        var = null;
                    }
                }
            }
        } else {
            if (((String) param).matches(Patterns.exVal)) {
                var = new VarF((String) param);
            } else {
                if (((String) param).matches(Patterns.exVec)) {
                    var = new VarV((String) param);
                } else {
                    if (((String) param).matches(Patterns.exMat)) {
                        var = new VarM((String) param);
                    } else {
                        var = null;
                    }

                }
            }
        }
        return var;
    }
}
