package com.example.demojpa.infraestructure.error;

import org.springframework.http.HttpStatus;

public class RoldDuplicationException extends RuntimeException {
    private String message;
    private HttpStatus status;
    public RoldDuplicationException(String message, HttpStatus statusCode){
        super(message);
        this.message=message;
        this.status=statusCode;
    }
    public String getMessage() {
        return message;
    }
    public HttpStatus getStatus() {
        return status;
    }
    

    

}
