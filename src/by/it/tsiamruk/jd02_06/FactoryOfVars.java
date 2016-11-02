package by.it.tsiamruk.jd02_06;

import by.it.tsiamruk.matlab.Patterns;
import by.it.tsiamruk.matlab.vars.Var;
import by.it.tsiamruk.matlab.vars.VarF;
import by.it.tsiamruk.matlab.vars.VarM;
import by.it.tsiamruk.matlab.vars.VarV;

/**
 * Created by waldemar on 25/10/2016.
 */
public class FactoryOfVars implements VarFactoryIF {
    @Override
    public Var createVar(String line) {
        if (line.matches(Patterns.exVal))
            return new VarF(line);
        if (line.matches(Patterns.exVec))
            return new VarV(line);
        if (line.matches(Patterns.exMat))
            return new VarM(line);
        return null;
    }
}
