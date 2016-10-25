package by.it.artiuschik.mathlab.errors;

public class IncorrectBracketsException extends Exception{
    public IncorrectBracketsException() {
        super();
    }

    public IncorrectBracketsException(String message) {
        super(message);
    }

    public IncorrectBracketsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectBracketsException(Throwable cause) {
        super(cause);
    }
}
