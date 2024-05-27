package com.example.MySQLSpring;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleSQLIntegrityViolationException(HttpServletRequest req, SQLIntegrityConstraintViolationException ex){
        String error = "Unable to perform post" + ex.getMessage();
        return buildErrorResponse(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest req, NoSuchElementException ex){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND);
        errorResponse.setMessage("No element exists: " + req.getRequestURI());
        return buildErrorResponse(errorResponse);
    }

    @ExceptionHandler(ItemAlreadyExists.class)
    public ResponseEntity<Object> handleItemAlreadyExistsException(HttpServletRequest req, ItemAlreadyExists ex){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND);
        errorResponse.setMessage(ex.getMessage());
        return buildErrorResponse(errorResponse);
    }

    public ResponseEntity<Object> buildErrorResponse(ErrorResponse errorResponse){
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());
    }
}
