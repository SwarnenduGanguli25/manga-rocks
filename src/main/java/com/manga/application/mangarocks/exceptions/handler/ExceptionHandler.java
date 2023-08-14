package com.manga.application.mangarocks.exceptions.handler;

import com.manga.application.mangarocks.controller.CategoryControllerImpl;
import com.manga.application.mangarocks.dto.ErrorResponse;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.enums.ErrorType;
import com.manga.application.mangarocks.exceptions.ConstraintViolationException;
import com.manga.application.mangarocks.exceptions.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(assignableTypes = {CategoryControllerImpl.class})
@Slf4j
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<GenericResponse> handleConstraintException(ConstraintViolationException exception) {
        log.error("Constraint Violation Exception {}", ExceptionUtils.getStackTrace(exception));
        ErrorType e = ErrorType.BAD_REQUEST;
        GenericResponse genericResponse = GenericResponse.builder().errorResponse(
                new ErrorResponse(
                        e.getErrorCode(),
                        e.getErrorDescription()
                )
        ).build();
        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
    public ResponseEntity<GenericResponse> handleValidationException(ValidationException exception) {
        log.error("Validation Exception {}", ExceptionUtils.getStackTrace(exception));
        ErrorType e = ErrorType.BAD_REQUEST;
        GenericResponse genericResponse = GenericResponse.builder().errorResponse(
                new ErrorResponse(
                        e.getErrorCode(),
                        e.getErrorDescription()
                )
        ).build();
        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }
}
