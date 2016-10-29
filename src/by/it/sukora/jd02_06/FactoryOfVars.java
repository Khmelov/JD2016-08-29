package by.it.sukora.jd02_06;

import by.it.sukora.jd02_04.matlab_with_parser.Patterns;
import by.it.sukora.jd02_04.matlab_with_parser.vars.Var;
import by.it.sukora.jd02_04.matlab_with_parser.vars.VarF;
//import by.it.tsiamruk.matlab.vars.VarM;

/**
 * Created by Sukora Stas.
 */
public class FactoryOfVars implements VarFactoryIF {
    @Override
    public Var createVar(String line) {
        if (line.matches(Patterns.exVal))
            return new VarF(line);
//        if (line.matches(Patterns.exVec))
//            return new VarV(line);
//        if (line.matches(Patterns.exMat))
//            return new VarM(line);
        return null;
    }
}
