package by.it.akhmelev.jd01_10.matlab_v2.interfaces;

public interface IVar extends IAdd,IDiv,IMul,ISub {
    String toString();            //метод вывода переменной в строку
    void setFrom(String str);     //метод чтения значения переменной из строки
}

