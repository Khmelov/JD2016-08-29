package by.it.artiuschik.jd_01_09.mathlab.utils;

public class Patterns {
    static public String vector="\\{ *(-?[0-9.]+ *,*)+ *}";
    static public String number ="-?([0-9.])+";
    static public String matrix="\\{(\\{ *(-?[0-9\\.]+ *,*)+ *} *,* *)+}";
    static public String oper="[-+*/=]";
    static public String varName="[A-Za-z]+";
    static public String any="("+matrix+")|("+vector+")|("+number+")|("+oper+")|("+varName+")";
}
