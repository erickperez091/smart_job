package com.example.prueba_smart_job.controllers;

import com.example.prueba_smart_job.dto.ErrorDTO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserControllerExceptionHandling {

    @ResponseStatus( HttpStatus.CONFLICT )
    @ExceptionHandler( DuplicateKeyException.class )
    public ResponseEntity< Object > handleDuplicateEntry( DuplicateKeyException ex ) {
        ErrorDTO errorDTO = new ErrorDTO( ex.getMessage() );
        return new ResponseEntity<>( errorDTO, HttpStatus.CONFLICT );
    }


    @ResponseStatus( HttpStatus.BAD_REQUEST )
    @ExceptionHandler( RuntimeException.class )
    public ResponseEntity< Object > handleDuplicateEntry( RuntimeException ex ) {
        ErrorDTO errorDTO = new ErrorDTO( ex.getMessage() );
        return new ResponseEntity<>( errorDTO, HttpStatus.BAD_REQUEST );
    }
}
