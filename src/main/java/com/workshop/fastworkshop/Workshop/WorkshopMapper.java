package com.workshop.fastworkshop.Workshop;

import com.workshop.fastworkshop.Colaboradores.ColaboradorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WorkshopMapper {

    @Autowired
    private ColaboradorMapper colaboradorMapper;


    public WorkshopDto toDTO(WorkshopEntity entity) {
        if (entity == null) return null;

        return new WorkshopDto(
                entity.getNome(), entity.getDataRealizacao(), entity.getDescricao(), entity.getColaboradores().stream().map(x -> x.getNome()).collect(Collectors.toList())
        );
    }

    public WorkshopEntity toEntity(WorkshopDto dto) {
        if (dto == null) return null;
        return new WorkshopEntity(
                dto.nome(), dto.dataRealizacao(), dto.descricao()
        );
    }

    public ResponseWorkshop toResponse(WorkshopEntity entity) {
        return new ResponseWorkshop(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getDataRealizacao()
        );
    }
}
