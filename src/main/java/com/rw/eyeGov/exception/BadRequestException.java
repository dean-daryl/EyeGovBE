package com.rw.eyeGov.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
    public BadRequestException(Exception ex) {
        super(ex);
    }
    public BadRequestException(Exception ex, String message) {
        super(message, ex);
    }
}