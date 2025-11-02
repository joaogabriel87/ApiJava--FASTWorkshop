package com.workshop.fastworkshop.Erro;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
