package utilities;

public class EmptyQueueException extends RuntimeException {
    // No-arg constructor
    public EmptyQueueException() {
        super();
    }

    // Constructor with a message
    public EmptyQueueException(String message) {
        super(message);
    }
}