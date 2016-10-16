package by.it.artiuschik.jd_02_04.mathlab.utils;

public class Patterns {
    static public String exVal="-?[0-9.]+"; //числа
    static public String exVec="\\{[^{]+}";//вектора
    static public String exMat="\\{\\{.+}}";       //матрицы
    static public String exOperation ="[-+*/=]";    //операция
    static public String varName="[A-Za-z]+";//название переменной
    static String innerBrackets="\\([^\\(\\)]+\\)";//выражение вида (8+8), т.е. скобки в которых нет скобок

}

