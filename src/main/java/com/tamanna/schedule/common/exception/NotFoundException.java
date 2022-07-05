package com.tamanna.schedule.common.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
