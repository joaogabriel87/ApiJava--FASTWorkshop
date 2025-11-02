package com.workshop.fastworkshop.Erro;

public class ColaboradorNaoPresenteException extends BusinessException {
    public ColaboradorNaoPresenteException(Long colaboradorId, Long ataId) {
        super("Colaborador " + colaboradorId + " não está presente na ata " + ataId);
    }
}
