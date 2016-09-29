package by.it.vashukevich.jd01_09.mathlab;

/**
 * Created by Admin on 16.09.16.
 */
public class Var implements IOperation{
    @Override
    public Var add(Var var) {
        new Error("Сложение невозможно");
        return var;
    }

    @Override
    public Var sub(Var var) {
        new Error("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Умножение невозможно");
        return null;
    }

    @Override
    public Var div(Var var) {
        new Error("Деление невозможно");
        return null;
    }
}
