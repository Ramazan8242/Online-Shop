package edu.attractor.onlineshop.Exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.BindException;

public class BindingExceptionHandler {
//    @ExceptionHandler(BindException.class)
//    private ResponseEntity<?> handleBind(BindException ex){
//        var errors = ex.getFieldErrors()
//                .stream()
//                .map(fe->String.format("%s -> %s",
//                        fe.getField(),fe.getDefaultMessage()))
//                .collect(toList());
//        return ResponseEntity.unprocessableEntity()
//                .body(errors);
//    }
}
