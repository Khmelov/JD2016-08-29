package by.it.savelyeva.jd_01_13.matlab;

/**
 * Created by nato on 10/1/16.
 */
public class VarDimensionException extends Exception {
    public VarDimensionException() {    }

    public VarDimensionException(String message, Throwable Exception) {
        super(message, Exception);
    }

    public VarDimensionException(String message) {
        super(message);
    }

    public VarDimensionException(Throwable Exception) { super(Exception); }
}
