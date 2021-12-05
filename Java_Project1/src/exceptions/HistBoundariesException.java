package exceptions;

public class HistBoundariesException extends IllegalArgumentException{
    public HistBoundariesException(String message) {
        super(message);
    }
}