package com.manga.application.mangarocks.exceptions;

public class InvalidIdException extends RuntimeException {
    private String errorMessage;

    public InvalidIdException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
