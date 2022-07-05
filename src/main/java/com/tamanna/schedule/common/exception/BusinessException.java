package com.tamanna.schedule.common.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}
