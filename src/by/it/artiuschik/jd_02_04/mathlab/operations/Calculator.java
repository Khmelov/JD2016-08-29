package by.it.artiuschik.jd_02_04.mathlab.operations;

import by.it.artiuschik.jd_02_04.mathlab.errors.Error;
import by.it.artiuschik.jd_02_04.mathlab.vars.Var;
import by.it.artiuschik.jd_02_04.mathlab.vars.VarF;
import by.it.artiuschik.jd_02_04.mathlab.vars.VarM;
import by.it.artiuschik.jd_02_04.mathlab.vars.VarV;

//операции с  Var
public class Calculator {
    public static void assign(String varName, Var var) {
        if (var instanceof VarF) {
            VarFOperations.assign(varName, (VarF) var);
        }
        if (var instanceof VarV) {
            VarVOperations.assign(varName, (VarV) var);
        }
        if (var instanceof VarM) {
            VarMOperations.assign(varName, (VarM) var);
        }

    }

    public static Var add(Var v1, Var v2) {
        if (v1 instanceof VarF) {
            if (v2 instanceof VarV) {
                return VarFOperations.add((VarF) v1, (VarV) v2);
            }
            if (v2 instanceof VarF) {
                return VarFOperations.add((VarF) v1, (VarF) v2);
            }
            if (v2 instanceof VarM) {
                new Error("Нельзя сложить вектор и матрицу!");
                return null;
                //return VarFOperations.add((VarF) v1, (VarM)v2);
            }
        }
        if (v1 instanceof VarV) {
            if (v2 instanceof VarF) {
                return VarVOperations.add((VarV) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarVOperations.add((VarV) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                new Error("Нельзя сложить вектор и матрицу!");
                return null;
                //return VarVOperations.add((VarV) v1,(VarM) v2);
            }
        }
        if (v1 instanceof VarM) {
            if (v2 instanceof VarF) {
                return VarMOperations.add((VarM) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarMOperations.add((VarM) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                return VarMOperations.add((VarM) v1, (VarM) v2);
            }
        }
        new Error("Сложение невозможно!");
        return null;
    }

    //Вычитание
    public static Var sub(Var v1, Var v2) {
        if (v1 instanceof VarF) {
            if (v2 instanceof VarF) {
                return VarFOperations.sub((VarF) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarFOperations.sub((VarF) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                new Error("Нельзя вычесть вектор и матрицу!");
                return null;
                //return VarFOperations.add((VarF) v1, (VarM)v2);
            }
        }
        if (v1 instanceof VarV) {
            if (v2 instanceof VarF) {
                return VarVOperations.sub((VarV) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarVOperations.sub((VarV) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                new Error("Нельзя сложить вектор и матрицу!");
                return null;
                //return VarVOperations.add((VarV) v1,(VarM) v2);
            }
        }
        if (v1 instanceof VarM) {
            if (v2 instanceof VarF) {
                return VarMOperations.sub((VarM) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarMOperations.sub((VarM) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                return VarMOperations.sub((VarM) v1, (VarM) v2);
            }
        }
        new Error("Сложение невозможно!");
        return null;
    }

    public static Var mul(Var v1, Var v2) {
        if (v1 instanceof VarF) {
            if (v2 instanceof VarF) {
                return VarFOperations.mul((VarF) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarFOperations.mul((VarF) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                new Error("Нельзя умножить вектор и матрицу!");
                return null;
                //return VarFOperations.add((VarF) v1, (VarM)v2);
            }
        }
        if (v1 instanceof VarV) {
            if (v2 instanceof VarF) {
                return VarVOperations.mul((VarV) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarVOperations.mul((VarV) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                new Error("Нельзя сложить вектор и матрицу!");
                return null;
                //return VarVOperations.add((VarV) v1,(VarM) v2);
            }
        }
        if (v1 instanceof VarM) {
            if (v2 instanceof VarF) {
                return VarMOperations.mul((VarM) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarMOperations.mul((VarM) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                return VarMOperations.mul((VarM) v1, (VarM) v2);
            }
        }
        new Error("Сложение невозможно!");
        return null;
    }

    public static Var div(Var v1, Var v2) {
        if (v1 instanceof VarF) {
            if (v2 instanceof VarF) {
                return VarFOperations.div((VarF) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarFOperations.div((VarF) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                new Error("Нельзя сложить вектор и матрицу!");
                return null;
                //return VarFOperations.add((VarF) v1, (VarM)v2);
            }
        }
        if (v1 instanceof VarV) {
            if (v2 instanceof VarF) {
                return VarVOperations.div((VarV) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarVOperations.div((VarV) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                new Error("Нельзя сложить вектор и матрицу!");
                return null;
                //return VarVOperations.add((VarV) v1,(VarM) v2);
            }
        }
        if (v1 instanceof VarM) {
            if (v2 instanceof VarF) {
                return VarMOperations.div((VarM) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarMOperations.div((VarM) v1, (VarV) v2);
            }
            if (v2 instanceof VarM) {
                return VarMOperations.div((VarM) v1, (VarM) v2);
            }
        }
        new Error("Сложение невозможно!");
        return null;
    }

}
