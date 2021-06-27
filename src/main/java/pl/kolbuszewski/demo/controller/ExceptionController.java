package pl.kolbuszewski.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Map<String, String>> handleWrongPassword(ArithmeticException e){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Dont divide by zero! Probably number of user followers equals 0!"));
    }
}
