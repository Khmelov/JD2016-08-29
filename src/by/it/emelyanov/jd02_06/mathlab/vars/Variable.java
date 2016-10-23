package by.it.emelyanov.jd02_06.mathlab.vars;


import by.it.emelyanov.jd02_06.mathlab.error.Error;

public abstract class Variable implements Ivariable {
    @Override
    public Variable add(Variable var) {
        new Error("Сложение невозможно");
        return var;
    }

    @Override
    public Variable sub(Variable var) {
        new Error("Вычитание невозможно");
        return var;
    }

    @Override
    public Variable mul(Variable var) {
        new Error("Умножение невозможно");
        return var;
    }

    @Override
    public Variable div(Variable var) {
        new Error("Делениение невозможно");
        return var;
    }
}
