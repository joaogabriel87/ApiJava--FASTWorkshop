package com.workshop.fastworkshop.Erro;


public class ColaboradorDuplicadoException extends BusinessException {
    public ColaboradorDuplicadoException(String nome) {
        super("Já existe um colaborador cadastrado com o nome: " + nome);
    }
}
