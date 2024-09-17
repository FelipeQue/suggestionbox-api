package br.com.fullstack.suggestionbox.exceptions;

import br.com.fullstack.suggestionbox.dtos.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception exception) {
        return ResponseEntity.status(500).body(
                ErrorResponse.builder()
                        .exceptionClass(exception.getClass().getSimpleName())
                        .code("500")
                        .message(exception.getLocalizedMessage())
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handle(HttpMessageNotReadableException exception) {
        return ResponseEntity.status(400).body(
                ErrorResponse.builder()
                        .exceptionClass(exception.getClass().getSimpleName())
                        .code("400")
                        .message(exception.getLocalizedMessage())
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handle(DataIntegrityViolationException exception) {
        return ResponseEntity.status(400).body(
                ErrorResponse.builder()
                        .exceptionClass(exception.getClass().getSimpleName())
                        .code("400")
                        .message(exception.getMessage())
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(400).body(
                ErrorResponse.builder()
                        .exceptionClass(exception.getClass().getSimpleName())
                        .code("400")
                        .message("Required fields cannot be empty.")
                        .fields(exception
                                .getFieldErrors()
                                .stream()
//                                .map(FieldError::toString)
                                .map(FieldError::getField)
                                .toList())
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(NotFoundException exception) {
        return ResponseEntity.status(404).body(
                ErrorResponse.builder()
                        .exceptionClass(exception.getClass().getSimpleName())
                        .code("404")
                        .message(exception.getLocalizedMessage())
                        .build()
        );
    }

}
