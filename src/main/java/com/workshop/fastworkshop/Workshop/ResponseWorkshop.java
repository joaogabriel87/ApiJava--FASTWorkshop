package com.workshop.fastworkshop.Workshop;

import java.time.LocalDate;

public record ResponseWorkshop(
        Long id,
        String nome,
        String descricao,
        LocalDate dataRealizacao
) {
}
