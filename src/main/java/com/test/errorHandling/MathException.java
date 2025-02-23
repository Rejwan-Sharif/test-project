package com.test.errorHandling;

import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MathException extends RuntimeException{
    public MathException(String message) {
    super(message);
    }

}
