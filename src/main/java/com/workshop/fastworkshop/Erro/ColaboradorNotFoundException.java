package com.workshop.fastworkshop.Erro;

public class ColaboradorNotFoundException extends BusinessException {
    public ColaboradorNotFoundException(Long id) {
        super("Colaborador não encontrado com ID " + id);
    }
}