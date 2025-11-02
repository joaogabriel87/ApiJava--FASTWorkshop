package com.workshop.fastworkshop.Erro;

public class WorkshopNotFoundException extends BusinessException{
    public WorkshopNotFoundException(Long id) {
        super("Workshop não encontrado com ID " + id);
    }
}
