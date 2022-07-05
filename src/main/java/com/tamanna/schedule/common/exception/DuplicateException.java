package com.tamanna.schedule.common.exception;

public class DuplicateException extends RuntimeException {

    public DuplicateException(String errorMessage) {
        super(errorMessage);
    }
}
