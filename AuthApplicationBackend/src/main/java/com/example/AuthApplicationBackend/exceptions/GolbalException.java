package com.example.AuthApplicationBackend.exceptions;

import com.example.AuthApplicationBackend.DTO.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GolbalException {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourcesNotFound(ResourcesNotFoundException exception){
        ErrorResponse error=new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND,"intrrnal error");
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}
