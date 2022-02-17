package com.example.jumiatask.rest.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CategorizationExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleObjectNotFoundException(NoDataFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NO_CONTENT.value()
                , ex.getMessage()
                , LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleExceptions(Exception ex) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value()
                , ex.getMessage()
                , LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
