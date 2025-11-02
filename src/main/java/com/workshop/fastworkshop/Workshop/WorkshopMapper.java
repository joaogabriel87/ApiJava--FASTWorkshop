package com.workshop.fastworkshop.Workshop;

import com.workshop.fastworkshop.Colaboradores.ColaboradorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WorkshopMapper {

    @Autowired
    private ColaboradorMapper colaboradorMapper;



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
