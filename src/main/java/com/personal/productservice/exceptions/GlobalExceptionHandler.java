package com.personal.productservice.exceptions;

import com.personal.productservice.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ErrorDto handleException() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Product not found");
        errorDto.setStatus("error");
        return errorDto;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(ProductNotFoundException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        errorDto.setStatus("error");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }
}
