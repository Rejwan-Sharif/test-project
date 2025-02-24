package com.test.errorHandling;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public Object responseNotFound(HttpServletRequest request, ResourceNotFoundException notFoundException){
        List<Object> accept = Collections.singletonList(request.getHeader(HttpHeaders.ACCEPT));

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", Instant.now());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("error", MathException.class.getSimpleName());
//        errorResponse.put("message", ResourceNotFoundException.getMessage());

        if (!accept.contains(MediaType.TEXT_HTML_VALUE)){
            return new ModelAndView("error",
                   errorResponse );
        }
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
