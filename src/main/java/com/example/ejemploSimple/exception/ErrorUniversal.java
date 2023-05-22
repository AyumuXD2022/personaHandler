package com.example.ejemploSimple.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorUniversal {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataAccessException.class)
    public Map<String,Object>correoDuplicado(DataAccessException ex){
        Map<String,Object> error = new HashMap<>();
        error.put("mensaje","Error de correo DNO EXISTE");
        return error;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public Map<String,Object>objectoNoEncontrado(ObjectNotFoundException ex){
        Map<String,Object> error = new HashMap<>();
        error.put("mensaje",ex.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object>validacion(MethodArgumentNotValidException ex){
        Map<String,Object> error = new HashMap<>();
        List<String> errors = ex.getFieldErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .collect(Collectors.toList());
        error.put("errors", errors);
        error.put("mensaje","Llenas los campos restantes o escribir de la manera correcta");
        return error;
    }
}
