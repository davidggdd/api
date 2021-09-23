
package com.vitesia.api.errors;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    
    private final Logger log = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);
    
    
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity handleNoEntityFoundException(NoResultException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @ExceptionHandler({IllegalStateException.class, IllegalArgumentException.class})
    public ResponseEntity handleBadRequestException(RuntimeException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(getErrorFrom(ex));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity invalidInput(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        ApiError error = new ApiError();
        error.setCode("400");
        error.setDescription(ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
        return ResponseEntity.badRequest().body(error);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity invalidInput(ConstraintViolationException ex) {
        log.error(ex.getMessage(), ex);
        ApiError error = new ApiError();
        error.setCode("400");
        error.setDescription(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList()).toString());
        
        return ResponseEntity.badRequest().body(error);
    }
    
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity accessDenied(AccessDeniedException ex) {
        log.error(ex.getMessage(), ex);
        ApiError error = new ApiError();
        error.setCode("401");
        error.setDescription(ex.getMessage());
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }
    
    @ExceptionHandler(IOException.class)
    public ResponseEntity invalisCsvFile(IOException ex) {
        log.error(ex.getMessage(), ex);
        ApiError error = new ApiError();
        error.setCode("400");
        error.setDescription(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    private ApiError getErrorFrom(Exception exception) {
    	ApiError error = new ApiError();
        String message = exception.getMessage();
        if (message == null) {
            error.setCode("500");
            if (exception.getCause() != null && 
                    exception.getCause().getMessage() != null &&
                    !exception.getCause().getMessage().isEmpty())
                error.setDescription(exception.getCause().getMessage());
            else
                error.setDescription("No se ha proporcionado una descripción para este error");
            return error;
        }
        String[] tokens = message.split(":");
        if (tokens.length > 1) {
            error.setCode(tokens[0].trim());
            String description = "";
            for (int i = 1; i < tokens.length; ++i)
                description += tokens[i] + " ";
            error.setDescription(description.trim());
        } else {
            error.setCode("500");
            error.setDescription(tokens[0].trim());
        }
        return error;
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getErrorFrom(ex));
    }

}
