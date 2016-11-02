package by.it.artiuschik.mathlab.operations;

import by.it.artiuschik.mathlab.Runner;
import by.it.artiuschik.mathlab.data.ApplicationData;
import by.it.artiuschik.mathlab.vars.*;
//операции с  VarF
public class VarFOperations {
    //Присваивание
    public static void assign(String scalarName,VarF scalar)
    {
        ApplicationData.vars.put(scalarName,scalar);
    }
    //-------------------Сложение
    //Сложить число с числом
    public static Var add(VarF v1, VarF v2) {
        Runner.logger.writeToLogfile("Сложение скаляров","log.txt");
        return new VarF(v1.value + v2.value);
    }

    //Сложить число  с вектором
    public static Var add(VarF v1, VarV v2) {
        return VarVOperations.add(v2, v1);
    }

    //сложить число с матрицей
    public static Var add(VarF v1, VarM v2) {
        return VarMOperations.add(v2, v1);
    }

    //--------------Вычитание
    //вычесть из числа число
    public static Var sub(VarF v1, VarF v2) {
        Runner.logger.writeToLogfile("Вычитание скаляров","log.txt");
        return new VarF(v1.value - v2.value);
    }

    //Вычесть из  числа с матрицу
    public static Var sub(VarF v1, VarM v2) {
        return VarMOperations.sub(v2, v1);
    }

    //вычесть из числа вектор
    public static Var sub(VarF v1, VarV v2) {
        return VarVOperations.sub(v2, v1);
    }

    //--------------Умножение
    //число на число
    public static Var mul(VarF v1, VarF v2) {
        Runner.logger.writeToLogfile("Умножение скаляров","log.txt");
        return new VarF(v1.value * v2.value);
    }

    //число на вектор
    public static Var mul(VarF v1, VarV v2) {
        return VarVOperations.mul(v2, v1);
    }

    //число на матрицу
    public static Var mul(VarF v1, VarM v2) {
        return VarMOperations.mul(v2, v1);
    }

    //--------------Деление
    //число на число
    public static Var div(VarF v1, VarF v2) throws Exception{
        if(v2.value!=0) {
            Runner.logger.writeToLogfile("Деление скаляров","log.txt");
            return new VarF(v1.value / v2.value);
        }
        throw new Exception("Деление на 0!");
    }

    //число на вектор
    public static Var div(VarF v1, VarV v2) {
        return VarVOperations.div(v2, v1);
    }

    //число на матрицу
    public static Var div(VarF v1, VarM v2) {
        return VarMOperations.div(v2, v1);
    }
}
