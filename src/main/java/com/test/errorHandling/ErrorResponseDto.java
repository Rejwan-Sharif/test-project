package com.test.errorHandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorResponseDto {

    private Date timestamp;
    private int statusCode;
    private String status;
    private String message;

    public ErrorResponseDto(int statusCode,String status, String message) {
        this.timestamp = new Date();
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }
}
