package models;

public class NotAllowedException extends Exception {
    public NotAllowedException(String message) {
        super(message);
    }
}