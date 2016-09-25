package by.it.tsydzik.jd01_09;

/**
 * @author Eugene Tsydzik
 * @since 9/19/16.
 */
public abstract class Var implements IOperable {
    @Override
    public Var add(Var var) {
        new Error("Addition is impossible");
        return var;
    }

    @Override
    public Var sub(Var var) {
        new Error("Substraction is impossible");
        return var;
    }

    @Override
    public Var mul(Var var) {
        new Error("Multiplication is impossible");
        return var;
    }

    @Override
    public Var div(Var var) {
        new Error("Division is impossible");
        return var;
    }
}
