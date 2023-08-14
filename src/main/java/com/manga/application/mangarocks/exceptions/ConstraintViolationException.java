package com.manga.application.mangarocks.exceptions;

import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ConstraintViolationException extends RuntimeException {
    private Set<ConstraintViolation<?>> constraintViolations;

    public ConstraintViolationException(Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(constraintViolations.iterator().next().getMessage());
        this.constraintViolations = new HashSet<>(constraintViolations);
    }
}
