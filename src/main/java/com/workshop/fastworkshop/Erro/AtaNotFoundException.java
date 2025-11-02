package com.workshop.fastworkshop.Erro;

public class AtaNotFoundException extends BusinessException {
    public AtaNotFoundException(Long id) {
        super("Ata não encontrada com ID " + id);
    }
}