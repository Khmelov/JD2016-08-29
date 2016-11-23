package by.it.artiuschik.jd_02_04.mathlab.utils;

public class Patterns {
    static public String exVal="-?[0-9.]+"; //числа
    static public String exVec="\\{[^{]+}";//вектора
    static String exMat="\\{\\{.+}}";       //матрицы
    static String exOperation ="[-+*/=]";    //операция
    static String varName="[A-Za-z]+";//название переменной
    static String innerBrackets="\\([^\\(\\)]+\\)";//выражение вида (8+8), т.е. скобки в которых нет скобок

}

