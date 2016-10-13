package by.it.artiuschik.jd_01_09.mathlab.operations;

import by.it.artiuschik.jd_01_09.Error;
import by.it.artiuschik.jd_01_09.mathlab.vars.*;

//операции с  VarM
public class VarMOperations {
    //-------------------Сложение
    //Сложить матрицу с  матрицей
    public static Var add(VarM v1, VarM v2) {
        int v1Cols = v1.matrix[0].length;
        int v2Cols = v2.matrix[0].length;
        int v1Rows = v1.matrix.length;
        int v2Rows = v2.matrix.length;
        if ((v1Cols == v2Cols) && (v1Rows == v2Rows)) {
            VarM result = new VarM(v1.matrix);
            for (int i = 0; i < v1Rows; i++) {
                for (int j = 0; j < v1Cols; j++) {
                    result.matrix[i][j] += v2.matrix[i][j];
                }
            }
            return result;
        }
        new Error("Нельзя сложить векторы разной длины!");
        return null;
    }

    //Сложить матрицу с вектором
    public static Var add(VarM v1, VarV v2) {
        new Error("Сложение невозможно");
        return null;
    }

    //сложить матрицу с числом
    public static Var add(VarM v1, VarF v2) {
        VarM result = new VarM(v1.matrix);
        for (int i = 0; i < result.matrix.length; i++) {
            for (int j = 0; j < result.matrix[0].length; j++) {
                result.matrix[i][j] += v2.value;
            }
        }
        return result;
    }

    //--------------Вычитание
    //вычесть из матрицы матрицу
    public static Var sub(VarM v1, VarM v2) {
        return add(v1, (VarM) mul(v2, new VarF(-1)));
    }

    //Вычесть из  матрицы вектор
    public static Var sub(VarM v1, VarV v2) {
        return VarVOperations.sub(v2, v1);
    }

    //вычесть из матрицы  число
    public static Var sub(VarM v1, VarF v2) {
        return add(v1, (VarF) by.it.artiuschik.jd_01_09.mathlab.operations.VarFOperations.mul(v2, new VarF(-1)));
    }

    //--------------Умножение
    //матрица на матрицу
    public static Var mul(VarM v1, VarM v2) {
        int v1Cols = v1.matrix[0].length;
        int v1Rows = v1.matrix.length;
        int v2Rows = v2.matrix.length;
        int v2Cols = v2.matrix[0].length;
        if (v1Cols == v2Rows) {
            VarM result = new VarM(new double[v1Rows][v2Cols]);
            for (int i = 0; i < v1Rows; i++) {
                for (int j = 0; j < v2Cols; j++) {
                    for (int k = 0; k < v1Cols; k++) {
                        result.matrix[i][j] += v1.matrix[i][k] * v2.matrix[k][j];
                    }
                }
            }
            return result;
        }
        new Error("Нельзя умножить матрицы!");
        return null;
    }

    //матрица на вектор
    public static Var mul(VarM v1, VarV v2) {
        if (v1.matrix[0].length == v2.value.length) {
            VarV result = new VarV(new double[v1.matrix.length]);
            for (int i = 0; i < v1.matrix.length; i++) {
                for (int j = 0; j < v2.value.length; j++) {
                    result.value[i] += v1.matrix[i][j] * v2.value[j];
                }
            }
            return result;
        }
        new Error("Нельзя умножить вектор на матрицу!");
        return null;
    }

    //матрица на число
    public static Var mul(VarM v1, VarF v2) {
        VarM result = new VarM(v1.matrix);
        for (int i = 0; i < v1.matrix.length; i++) {
            for (int j = 0; j < v1.matrix[0].length; j++) {
                result.matrix[i][j] *= v2.value;
            }

        }
        return result;
    }

    //--------------Деление
    //матрица на матрицу
    public static Var div(VarM v1, VarM v2) {
        new Error("Операция невозможна!");
        return null;
    }

    //матрица на вектор
    public static Var div(VarM v1, VarV v2) {
        new Error("Операция невозможна!");
        return null;
    }

    //матрица на число
    public static Var div(VarM v1, VarF v2) {
        VarM result = new VarM(v1.matrix);
        for (int i = 0; i < v1.matrix.length; i++) {
            for (int j = 0; j < v1.matrix[0].length; j++) {
                result.matrix[i][j] /= v2.value;
            }

        }
        return result;
    }


}
