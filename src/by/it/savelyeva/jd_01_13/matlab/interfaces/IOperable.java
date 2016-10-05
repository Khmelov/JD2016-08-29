package by.it.savelyeva.jd_01_13.matlab.interfaces;

import by.it.savelyeva.jd_01_13.matlab.VarDimensionException;
import by.it.savelyeva.jd_01_13.matlab.vars.Var;

/**
 * Created by nato on 9/16/16.
 */
public interface IOperable {
    Var add(Var var) throws VarDimensionException;
    Var sub(Var var) throws VarDimensionException;
    Var mul(Var var) throws VarDimensionException;
    Var div(Var var);
    Var assign(String s);
}