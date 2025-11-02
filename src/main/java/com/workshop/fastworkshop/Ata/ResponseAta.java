package com.workshop.fastworkshop.Ata;

import java.util.List;

public record ResponseAta(
        Long id,
        String workshopNome,
        List<String> colaboradores
) {
}
