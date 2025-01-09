package exercise.Module2;

public class CustomException extends RuntimeException{

    public CustomException() {
        super("Custom Exception");
    }

    public CustomException(String message) {
        super(message);
    }
}
