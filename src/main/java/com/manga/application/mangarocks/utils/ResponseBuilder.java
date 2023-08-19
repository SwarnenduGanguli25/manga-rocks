package com.manga.application.mangarocks.utils;

import com.manga.application.mangarocks.dto.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ResponseBuilder {

    public <T> ResponseEntity<GenericResponse> getSuccessResponse(T message, HttpStatus httpStatus) {
        GenericResponse genericResponse = GenericResponse.builder().successResponse(message).build();
        return new ResponseEntity<>(genericResponse, httpStatus);
    }
}
