package com.example.emp.Exceptions;

import com.example.emp.model.EmpCustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomeException.class)
    public ResponseEntity<?> customeException(CustomeException customeException){

        return  new ResponseEntity<>(
                new EmpCustomResponse<>(
                        "02",
                        "fail",
                        customeException.getMessage()), HttpStatus.BAD_REQUEST

                );

    }
}
