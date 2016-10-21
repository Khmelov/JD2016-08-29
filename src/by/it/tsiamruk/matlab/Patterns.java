package by.it.tsiamruk.matlab;

public class Patterns {
    //регулярки
    static public String exVal = "-?[0-9.]+";                                //числа
    static public String exVec = "\\{(\\d*\\.?\\d+\\,?\\s?)+\\}";                       //вектора
    static public String exMat = "\\{\\(.+\\),?}";                           //матрицы
    static public String exAny = "(" + exMat + ")|(" + exVec + ")|(" + exVal + ")";       //одно из...
    static public String exOper = "[-+*/]";                                   //операция
    static public String exFull= "("+exAny+")"+
                                 "(" +exOper+")"+
                                 "(" +exAny +")"; //выражение целиком

}
