/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author Radu
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
    
      @ExceptionHandler(PersonNotFoundException.class)
      @ResponseStatus(value = HttpStatus.NOT_FOUND)
      public ErrorMsg personNotFoundException(PersonNotFoundException ex)
      {
          return new ErrorMsg(ex.getMessage(), HttpStatus.NOT_FOUND.value());
      }
    
}
