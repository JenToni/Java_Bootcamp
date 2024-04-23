package edu.school21.chat.Repository;


public class NotSavedSubEntityException extends RuntimeException {
    public NotSavedSubEntityException(String message) {
        super(message);
    }
    public NotSavedSubEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}