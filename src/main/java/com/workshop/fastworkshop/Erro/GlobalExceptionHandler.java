package com.workshop.fastworkshop.Erro;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ErroResponse> buildErroResponse(Exception e, HttpStatus status, String path) {
        ErroResponse erroResponse = new ErroResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                path
        );
        return ResponseEntity.status(status).body(erroResponse);
    }


    @ExceptionHandler({
            WorkshopNotFoundException.class,
            ColaboradorNotFoundException.class,
            AtaNotFoundException.class
    })
    public ResponseEntity<ErroResponse> handleNotFound(RuntimeException e, HttpServletRequest request) {
        return buildErroResponse(e, HttpStatus.NOT_FOUND, request.getRequestURI());
    }


    @ExceptionHandler({
            ColaboradorJaAdicionadoException.class,
            ColaboradorNaoPresenteException.class,
            MethodArgumentNotValidException.class,
            DataInvalidaException.class
    })
    public ResponseEntity<ErroResponse> handleBadRequest(Exception e, HttpServletRequest request) {
        return buildErroResponse(e, HttpStatus.BAD_REQUEST, request.getRequestURI());
    }


    @ExceptionHandler({
            WorkshopDuplicadoException.class,
            ColaboradorDuplicadoException.class,
            DataIntegrityViolationException.class
    })
    public ResponseEntity<ErroResponse> handleConflict(Exception e, HttpServletRequest request) {
        return buildErroResponse(e, HttpStatus.CONFLICT, request.getRequestURI());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> handleGeneric(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        return buildErroResponse(e, HttpStatus.INTERNAL_SERVER_ERROR, request.getRequestURI());
    }
}
