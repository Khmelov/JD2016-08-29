package by.it.sukora.JD1_10.HomeWork.interfaces;

public interface IVar extends IAdd,IDiv,IMul,ISub {
    String toString();            //метод вывода переменной в строку
    void setFrom(String str);     //метод чтения значения переменной из строки
}

