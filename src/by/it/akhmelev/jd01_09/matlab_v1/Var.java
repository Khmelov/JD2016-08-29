package by.it.akhmelev.jd01_09.matlab_v1;

public class Var implements IOperable{

    @Override
    public Var add(Var var) {
        new Error("Сложение невозможно");
        return var;
    }

    @Override
    public Var sub(Var var) {
        new Error("Вычитание невозможно");
        return var;
    }

    @Override
    public Var mul(Var var) {
        new Error("Умножение невозможно");
        return var;
    }

    @Override
    public Var div(Var var) {
        new Error("Деление невозможно");
        return var;
    }
}
