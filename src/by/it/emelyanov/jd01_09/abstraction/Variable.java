package by.it.emelyanov.jd01_09.abstraction;

import by.it.emelyanov.jd01_09.interfaces.Ivariable;
import by.it.emelyanov.jd01_09.error.Error;


public abstract class Variable implements Ivariable {
    @Override
    public Variable add(Variable var) {
        new Error("Сложение невозможно");
        return null;
    }

    @Override
    public Variable sub(Variable var) {
        new Error("Вычитание невозможно");
        return null;
    }

    @Override
    public Variable mul(Variable var) {
        new Error("Умножение невозможно");
        return null;
    }

    @Override
    public Variable div(Variable var) {
        new Error("Делениение невозможно");
        return null;
    }
}
