package lk.ijse.aad.greenshadow.exception;

public class InvalidCredentialsException extends Throwable {
    public InvalidCredentialsException() {
        super();
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
