package lesson.lesson10.btvn;

public class CustomException extends RuntimeException{

    public CustomException() {
        super("Custom Exception");
    }

    public CustomException(String message) {
        super(message);
    }
}
