package com.brandon.dummyapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class GuitarAuthException extends RuntimeException{

    public GuitarAuthException(String message) {
        super(message);
    }
}
