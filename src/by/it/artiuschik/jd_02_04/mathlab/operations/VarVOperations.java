package by.it.artiuschik.jd_02_04.mathlab.operations;

import by.it.artiuschik.jd_02_04.mathlab.data.Vars;
import by.it.artiuschik.jd_02_04.mathlab.errors.Error;
import by.it.artiuschik.jd_02_04.mathlab.vars.Var;
import by.it.artiuschik.jd_02_04.mathlab.vars.VarF;
import by.it.artiuschik.jd_02_04.mathlab.vars.VarM;
import by.it.artiuschik.jd_02_04.mathlab.vars.VarV;

public class VarVOperations {
    //Присваивание
    public static void assign(String vectorName,VarV vector)
    {
        Vars.vars.put(vectorName, vector);
    }

    //-------------------Сложение
    public static Var add(VarV v1, VarV v2) {
        int length1 = v1.value.length;
        int length2 = v2.value.length;
        if (length1 == length2) {
            VarV result = new VarV(v1.value);
            for (int i = 0; i < length1; i++) {
                result.value[i] += v2.value[i];
            }
            return result;
        }
        new Error("Нельзя сложить векторы разной длины!");
        return null;
    }

    //Сложить вектор с матрицей
    public static Var add(VarV v1, VarM v2) {
        new Error("Сложение невозможно");
        return null;
    }

    //сложить вектор с числом
    public static Var add(VarV v1, VarF v2) {
        VarV result = new VarV(v1.value);
        for (int i = 0; i < v1.value.length; i++) {
            result.value[i] += v2.value;
        }
        return result;
    }

    //--------------Вычитание
    public static Var sub(VarV v1, VarV v2) {
        int length1 = v1.value.length;
        int length2 = v2.value.length;
        if (length1 == length2) {
            VarV result = new VarV(v1.value);
            for (int i = 0; i < length1; i++) {
                result.value[i] -= v2.value[i];
            }
            return result;
        }
        new Error("Нельзя вычесть векторы разной длины!");
        return null;
    }

    //Вычесть из  вектора с матрицу
    public static Var sub(VarV v1, VarM v2) {
        new Error("Вычитание невозможно");
        return null;
    }

    //вычесть из вектора  число
    public static Var sub(VarV v1, VarF v2) {
        VarV result = new VarV(v1.value);
        for (int i = 0; i < v1.value.length; i++) {
            result.value[i] -= v2.value;
        }
        return result;
    }

    //--------------Умножение
    //вектор на вектор
    public static Var mul(VarV v1, VarV v2) {
        int length1 = v1.value.length;
        int length2 = v2.value.length;
        if (length1 == length2) {
            VarV result = new VarV(v1.value);
            for (int i = 0; i < length1; i++) {
                result.value[i] *= v2.value[i];
            }
            return result;
        }
        new Error("Нельзя умножить векторы разной длины!");
        return null;
    }

    //вектор на матрицу
    public static Var mul(VarV v1, VarM v2) {
        new Error("Нельзя умножить вектор на матрицу!");
        return null;
    }

    //вектор на число
    public static Var mul(VarV v1, VarF v2) {
        VarV result = new VarV(v1.value);
        for (int i = 0; i < v1.value.length; i++) {
            result.value[i] *= v2.value;
        }
        return result;
    }

    //--------------Деление
    //вектор на вектор
    public static Var div(VarV v1, VarV v2) {
        new Error("Операция невозможна!");
        return null;
    }

    //вектор на матрицу
    public static Var div(VarV v1, VarM v2) {
        new Error("Операция невозможна!");
        return null;
    }

    //вектор на число
    public static Var div(VarV v1, VarF v2) {
        VarV result = new VarV(v1.value);
        for (int i = 0; i < v1.value.length; i++) {
            result.value[i] /= v2.value;
        }
        return result;
    }

}
