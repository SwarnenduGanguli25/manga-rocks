package com.manga.application.mangarocks.utils;

import com.manga.application.mangarocks.exceptions.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Slf4j
public class ValidationUtil {

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T data, Class<?> clazz) {
        Set<ConstraintViolation<T>> violations = validator.validate(data, clazz);
        if (!violations.isEmpty()) throw new ConstraintViolationException(violations);
    }
}
