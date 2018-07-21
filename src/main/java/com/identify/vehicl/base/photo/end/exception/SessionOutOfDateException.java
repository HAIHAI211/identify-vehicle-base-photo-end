package com.identify.vehicl.base.photo.end.exception;

public class SessionOutOfDateException extends RuntimeException {
    public SessionOutOfDateException(String message) {
        super(message);
    }
}
