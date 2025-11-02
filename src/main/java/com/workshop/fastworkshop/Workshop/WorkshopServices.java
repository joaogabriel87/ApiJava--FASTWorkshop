package com.workshop.fastworkshop.Workshop;

import com.workshop.fastworkshop.Erro.DataInvalidaException;
import com.workshop.fastworkshop.Erro.WorkshopDuplicadoException;
import com.workshop.fastworkshop.Erro.WorkshopNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkshopServices {

    @Autowired
    private WorkshopRepository workshopRepository;
    @Autowired
    private WorkshopMapper workshopMapper;

    public WorkshopEntity createWorkshop(WorkshopDto dto) throws DataInvalidaException {
        boolean existe = workshopRepository.existsByNomeAndDataRealizacao(dto.nome(),dto.dataRealizacao());
        if(existe){
            throw new WorkshopDuplicadoException(dto.nome());
        }

        if(dto.dataRealizacao().isBefore(LocalDate.now())){
            throw new DataInvalidaException();
        }

        WorkshopEntity entity =workshopMapper.toEntity(dto);
        return workshopRepository.save(entity);
    }

    public List<WorkshopEntity> listarTodos() {
        return workshopRepository.findAll();
    }


    public WorkshopEntity buscarPorId(Long id) {
        return workshopRepository.findById(id)
                .orElseThrow(() -> new WorkshopNotFoundException(id));
    }


    public List<WorkshopEntity> buscarPorNome(String nome) {
         List<WorkshopEntity> workshop = workshopRepository.findByNomeContainingIgnoreCase(nome);
         if(workshop.isEmpty()){
             throw new WorkshopNotFoundException(0L);
         }

         return workshop;
    }


    public List<WorkshopEntity> buscarPorData(LocalDate data) {
        List<WorkshopEntity> workshops = workshopRepository.findByDataRealizacao(data);
        if (workshops.isEmpty()) {
            throw new WorkshopNotFoundException(0L);
        }
        return workshops;
    }

}
