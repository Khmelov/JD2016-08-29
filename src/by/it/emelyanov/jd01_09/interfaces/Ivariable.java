package by.it.emelyanov.jd01_09.interfaces;

import by.it.emelyanov.jd01_09.abstraction.Variable;


public interface Ivariable {
    Variable add(Variable var);

    Variable sub(Variable var);

    Variable mul(Variable var);

    Variable div(Variable var);

    String toString();

    void fromStr(String str);

}
