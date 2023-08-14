package com.manga.application.mangarocks.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum ErrorType {
    BAD_REQUEST("BAD_REQUEST", "Bad Request");

    private String errorCode;
    private String errorDescription;

    ErrorType(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
    }
