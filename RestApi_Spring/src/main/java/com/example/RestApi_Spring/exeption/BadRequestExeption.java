package com.example.RestApi_Spring.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//essa é a forma de criar uma execção // ficara no lugar de ResponseStatusExeption
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExeption extends RuntimeException{
    public BadRequestExeption(String message) {
        super(message);
    }
}
