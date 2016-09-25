package by.it.savelyeva.jd_01_09.interfaces;

import by.it.savelyeva.jd_01_09.vars.Var;

/**
 * Created by nato on 9/16/16.
 */
public interface IOperable {
    Var add(Var var);
    Var sub(Var var);
    Var mul(Var var);
    Var div(Var var);
}