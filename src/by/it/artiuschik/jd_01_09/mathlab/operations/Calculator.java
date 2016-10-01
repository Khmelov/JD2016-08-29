package by.it.artiuschik.jd_01_09.mathlab.operations;

import by.it.artiuschik.jd_01_09.Error;
import by.it.artiuschik.jd_01_09.mathlab.utils.Parser;
import by.it.artiuschik.jd_01_09.mathlab.vars.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//операции с  Var
public class Calculator {
    private static HashMap<String,Var> varibles=new HashMap<>();
    public static HashMap getVaribles()
    {
        return varibles;
    }
    public static Var add(Var v1, Var v2) {
        if (v1 instanceof VarF) {
            if (v2 instanceof VarF) {
                return VarFOperations.add((VarF) v1, (VarF) v2);
            }
            if (v2 instanceof VarV) {
                return VarFOperations.add((VarF) v1, (VarV) v2);
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

    public static Var calculate(String expression) {
        List<Object> list = new ArrayList(Parser.ParseFromString(expression));
        List<Object> vars = new ArrayList((ArrayList) list.get(1));
        String oper = (String) list.get(0);
        switch (oper)//зачем в  switch break?
        {
            case "+": {
                return add((Var)vars.get(0), (Var)vars.get(1));
            }
            case "-": {
                return sub((Var)vars.get(0), (Var)vars.get(1));
            }
            case "*": {
                return mul((Var)vars.get(0), (Var)vars.get(1));
            }
            case "/": {
                return div((Var)vars.get(0), (Var)vars.get(1));
            }
            case "=": {
                varibles.put((String)vars.get(0),(Var) vars.get(1));
            }
            default:
                return null;
        }
    }
}
