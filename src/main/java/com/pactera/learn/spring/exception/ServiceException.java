package com.pactera.learn.spring.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

}
