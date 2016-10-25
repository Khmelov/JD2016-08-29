package by.it.artiuschik.mathlab.operations;

import by.it.artiuschik.mathlab.Runner;
import by.it.artiuschik.mathlab.data.ApplicationData;
import by.it.artiuschik.mathlab.errors.Error;
import by.it.artiuschik.mathlab.vars.*;

public class VarVOperations {
    //Присваивание
    public static void assign(String vectorName, VarV vector) {
        ApplicationData.vars.put(vectorName, vector);
    }

    //-------------------Сложение
    public static Var add(VarV v1, VarV v2) throws Exception {
        int length1 = v1.value.length;
        int length2 = v2.value.length;
        if (length1 == length2) {
            VarV result = new VarV(v1.value);
            for (int i = 0; i < length1; i++) {
                result.value[i] += v2.value[i];
            }
            Runner.logger.writeToLogfile("Сложение векторов", "log.txt");
            return result;
        }
        throw new Exception("Нельзя сложить векторы разной длины!");
    }

    //Сложить вектор с матрицей
    public static Var add(VarV v1, VarM v2) throws Exception {
        throw new Exception("Сложение невозможно");
    }

    //сложить вектор с числом
    public static Var add(VarV v1, VarF v2) {
        VarV result = new VarV(v1.value);
        for (int i = 0; i < v1.value.length; i++) {
            result.value[i] += v2.value;
        }
        Runner.logger.writeToLogfile("Сложение вектора и скаляра", "log.txt");
        return result;
    }

    //--------------Вычитание
    public static Var sub(VarV v1, VarV v2) throws Exception {
        int length1 = v1.value.length;
        int length2 = v2.value.length;
        if (length1 == length2) {
            VarV result = new VarV(v1.value);
            for (int i = 0; i < length1; i++) {
                result.value[i] -= v2.value[i];
            }
            Runner.logger.writeToLogfile("Вычитание векторов", "log.txt");
            return result;
        }
        new Exception("Нельзя вычесть векторы разной длины!");
        return null;
    }

    //Вычесть из  вектора с матрицу
    public static Var sub(VarV v1, VarM v2) throws Exception {
        new Exception("Вычитание невозможно");
        return null;
    }

    //вычесть из вектора  число
    public static Var sub(VarV v1, VarF v2) {
        VarV result = new VarV(v1.value);
        for (int i = 0; i < v1.value.length; i++) {
            result.value[i] -= v2.value;
        }
        Runner.logger.writeToLogfile("Вычитание скаляра из вектора", "log.txt");
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
            Runner.logger.writeToLogfile("Умножение векторов", "log.txt");
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
        Runner.logger.writeToLogfile("Умножение вектора на скаляр", "log.txt");
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
        Runner.logger.writeToLogfile("Деление вектора на скаляр", "log.txt");
        return result;
    }

}
