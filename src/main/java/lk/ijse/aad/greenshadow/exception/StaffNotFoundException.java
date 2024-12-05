package lk.ijse.aad.greenshadow.exception;

public class StaffNotFoundException extends RuntimeException {
  public StaffNotFoundException() {
    super();
  }

  public StaffNotFoundException(String message) {
    super(message);
  }

  public StaffNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
