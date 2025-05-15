package exception;

public class InsufficientAvailableLimitException extends RuntimeException{
    public InsufficientAvailableLimitException(String message) {
        super(message);
    }
}
