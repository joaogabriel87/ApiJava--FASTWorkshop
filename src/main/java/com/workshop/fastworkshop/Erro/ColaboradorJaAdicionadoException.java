package com.workshop.fastworkshop.Erro;

public class ColaboradorJaAdicionadoException extends BusinessException {
    public ColaboradorJaAdicionadoException(Long colaboradorId, Long ataId) {
        super("Colaborador " + colaboradorId + " já está presente na ata " + ataId);
    }
}