package com.workshop.fastworkshop.Erro;

public class WorkshopDuplicadoException extends BusinessException {
    public WorkshopDuplicadoException(String nome) {
        super("Já existe um workshop cadastrado com o nome: " + nome);
    }
}
