package lk.ijse.aad.greenshadow.exception;

public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException() {
        super();
    }

    public EquipmentNotFoundException(String message) {
        super(message);
    }

    public EquipmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
