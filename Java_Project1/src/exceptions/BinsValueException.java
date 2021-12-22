package exceptions;

public class BinsValueException extends IllegalArgumentException {
    public BinsValueException(String message) {
        super(message);
    }
}