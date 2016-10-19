package by.it.sukora.jd02_04.matlab_with_parser.interfaces;

import by.it.sukora.jd02_04.matlab_with_parser.vars.Var;

public interface IMul {
    Var mul(Var var);   //умножение

    interface ISub {
        Var sub(Var var);   //вычитание
    }
}
