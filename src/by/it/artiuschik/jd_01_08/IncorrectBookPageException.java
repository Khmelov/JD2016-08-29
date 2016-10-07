package by.it.artiuschik.jd_01_08;

public class IncorrectBookPageException extends Exception {
    public IncorrectBookPageException() {
    }

    public IncorrectBookPageException(String message) {
        super(message);
    }

    public IncorrectBookPageException(String message, Throwable exception) {
        super(message, exception);
    }

    public IncorrectBookPageException(Throwable exception) {
        super(exception);
    }
}
