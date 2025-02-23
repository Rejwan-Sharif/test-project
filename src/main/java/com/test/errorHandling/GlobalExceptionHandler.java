package com.test.errorHandling;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponseDto responseNotFound(ResourceNotFoundException notFoundException){
        return new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.toString(),
                notFoundException.getMessage()
        );
    }




    @ResponseBody
    @ExceptionHandler(MathException.class)
    public ResponseEntity<?>mathException(MathException mathException){

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", Instant.now());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("error", MathException.class.getSimpleName());
        errorResponse.put("message", mathException.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
//                Collections.singletonMap("timestamp", Instant.now()
//                        "status",HttpStatus.INTERNAL_SERVER_ERROR,
//                        "error",MathException.class.getSimpleName(),
//                        "message",mathException.getMessage()
//                ));
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String errorHandler(Exception exception){
        return exception.getMessage();
    }
}
