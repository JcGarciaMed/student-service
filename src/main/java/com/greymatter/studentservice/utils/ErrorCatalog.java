package com.greymatter.studentservice.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    STUDENT_NOT_FOUND("ERR_STUDENT_001", "Student not found"),
    INVALID_STUDENT("ERR_STUDENT_002", "Invalid Student Parameters. "),
    GENERIC_ERROR("ERR_GENERIC_001", "An unexpected Error");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
