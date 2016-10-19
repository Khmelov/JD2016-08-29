package by.it.rudzko.Matlab.Vars;


import by.it.rudzko.Matlab.Interfaces.IVar;

public class VarSelector {
    public static IVar getVar (String s){
        IVar var=null;
        var=(s.charAt(0) != '{') ? new VarNum(s) : (s.charAt(1) != '{') ? new VarVec(s) : new VarMat(s);
        return var;
    }
}
