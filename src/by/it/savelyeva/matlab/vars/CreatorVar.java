package by.it.savelyeva.matlab.vars;

/**
 * Created by nato on 10/15/16.
 */
public class CreatorVar {

    public Var getVar(String s) {
        Var var = null;
        if (s.startsWith("{{") || s.startsWith("[[")) {
            var = new VarMatrix(s);
        } else if (s.startsWith("{") || s.startsWith("[")) {
            var = new VarVector(s);
        } else {
            var = new VarFloat(s);
        }
        return var;
    }
}
