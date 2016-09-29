package by.it.tsiamruk.matlab;

/**
 * Created by waldemar on 28/09/2016.
 */
public class Util {
    public static int prioriry(String str) {
        switch (str) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }
}
