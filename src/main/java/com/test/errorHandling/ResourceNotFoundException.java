package com.test.errorHandling;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
