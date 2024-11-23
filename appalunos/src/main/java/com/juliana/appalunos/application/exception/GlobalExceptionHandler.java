package com.juliana.appalunos.application.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(DataAccessException.class)
//    public ResponseEntity<ErrorMessage> handleSQLException(DataAccessException ex, HttpServletRequest request) {
//        String message = "Erro no banco de dados. Tente novamente mais tarde.";
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(new ErrorMessage(request, HttpStatus.INTERNAL_SERVER_ERROR, message));
//    }
}
