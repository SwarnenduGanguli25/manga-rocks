package com.manga.application.mangarocks.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends RuntimeException{
    private String message;

    public ValidationException(String message) {
        super(message);
        this.message = message;
    }
}
