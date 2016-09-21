package by.it.tsiamruk.matlab.interfaces;

/**
 * Created by waldemar on 21/09/2016.
 */
public interface IVar extends IAdd,IMul,ISub,IDiv {
    String toString();
    void setFrom(String str);
}
