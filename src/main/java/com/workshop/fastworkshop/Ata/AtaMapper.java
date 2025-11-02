package com.workshop.fastworkshop.Ata;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AtaMapper {
    public AtaDto toDTO(AtaEntity entity) {
        if (entity == null) return null;
        AtaDto dto = new AtaDto(
                entity.getWorkshop().getId(),
                entity.getColaboradores().stream()
                        .map(c -> c.getId())
                        .collect(Collectors.toList())
        );

        return dto;
    }

    public ResponseAta toResponse(AtaEntity entity) {
        if (entity == null) return null;

        String workshopNome = entity.getWorkshop() != null ? entity.getWorkshop().getNome() : null;
        var colaboradores = entity.getColaboradores() != null
                ? entity.getColaboradores().stream()
                .map(c -> c.getNome())
                .collect(Collectors.toList())
                : null;

        return new ResponseAta(entity.getId(), workshopNome, colaboradores);
    }
}
