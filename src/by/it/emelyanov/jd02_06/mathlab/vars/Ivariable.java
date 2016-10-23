package by.it.emelyanov.jd02_06.mathlab.vars;

public interface Ivariable {
    Variable add(Variable var);

    Variable sub(Variable var);

    Variable mul(Variable var);

    Variable div(Variable var);

    String toString();

    void fromStr(String str);

}
