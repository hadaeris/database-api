package com.brandon.dummyapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GuitarBadRequestException extends RuntimeException{
    public GuitarBadRequestException(String message) {
        super(message);
    }
}
