package br.com.mfgustavo.infrastruture.exceptions;

public class NotFoundOrderException extends RuntimeException {
    public NotFoundOrderException(String message) {
        super(message);
    }
}
