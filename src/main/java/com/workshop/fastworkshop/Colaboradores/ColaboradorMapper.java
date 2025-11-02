package com.workshop.fastworkshop.Colaboradores;

import org.springframework.stereotype.Component;

@Component
public class ColaboradorMapper {

    public ColaboradorDto toDTO(ColaboradorEntity entity) {
        if (entity == null) return null;
        return new ColaboradorDto(
                entity.getNome()
        );
    }

    public ColaboradorEntity toEntity(ColaboradorDto dto) {
        if (dto == null) return null;
        ColaboradorEntity entity = new ColaboradorEntity();
        entity.setNome(dto.nome());
        return entity;
    }

    public ResponseColaborador toResponse(ColaboradorEntity entity) {
        if (entity == null) return null;
        return new ResponseColaborador(
                entity.getId(),
                entity.getNome()
        );
    }

}
