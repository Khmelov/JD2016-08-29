package by.it.savelyeva.matlab.interfaces;

import by.it.savelyeva.matlab.VarDimensionException;
import by.it.savelyeva.matlab.vars.Var;

/**
 * Created by nato on 9/16/16.
 */
public interface IOperable {
    Var add(Var var) throws VarDimensionException;
    Var sub(Var var) throws VarDimensionException;
    Var mul(Var var) throws VarDimensionException;
    Var div(Var var);
}