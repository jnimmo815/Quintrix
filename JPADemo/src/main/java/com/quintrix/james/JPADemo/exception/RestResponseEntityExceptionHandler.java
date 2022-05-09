package com.quintrix.james.JPADemo.exception;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value 
      = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        
        Error error = new Error();
        error.setCustomMessage("Please use a different Id");;
        error.setMessage(ex.getMessage());  
        error.setHttpStatusCode(HttpStatus.CONFLICT.value());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    
    @ExceptionHandler({ EmployeeNotFoundException.class})
    public ResponseEntity<Object> handleException2(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof EmployeeNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            EmployeeNotFoundException unfe = (EmployeeNotFoundException) ex;
            
            Error error = new Error();
            error.setCustomMessage("Please use a different Id");
            error.setMessage(((EmployeeNotFoundException) ex).displayMessage);  
            error.setHttpStatusCode(HttpStatus.CONFLICT.value());
            
            return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);

            //return handleCarrNotFoundException(unfe, headers, status, request);
        
    }
		return null;
        
        
  }
}