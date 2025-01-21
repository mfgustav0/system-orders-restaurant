package br.com.mfgustavo.infrastruture.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(NotFoundOrderException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundEventException(NotFoundOrderException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());
        response.put("message", "The request event was not found, check the identifier and try again.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
