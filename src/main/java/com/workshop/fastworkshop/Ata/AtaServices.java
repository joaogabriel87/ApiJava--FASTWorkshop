package com.workshop.fastworkshop.Ata;


import com.workshop.fastworkshop.Colaboradores.ColaboradorEntity;
import com.workshop.fastworkshop.Colaboradores.ColaboradorServices;
import com.workshop.fastworkshop.Erro.AtaNotFoundException;
import com.workshop.fastworkshop.Erro.ColaboradorJaAdicionadoException;
import com.workshop.fastworkshop.Erro.ColaboradorNaoPresenteException;
import com.workshop.fastworkshop.Workshop.WorkshopEntity;
import com.workshop.fastworkshop.Workshop.WorkshopMapper;
import com.workshop.fastworkshop.Workshop.WorkshopServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AtaServices {

    @Autowired
    private AtaMapper ataMapper;
    @Autowired
    private AtaRepository ataRepository;
    @Autowired
    WorkshopServices workshopServices;
    @Autowired
    ColaboradorServices colaboradorServices;



    public AtaEntity criarAta(AtaDto dto) {
        WorkshopEntity workshop = workshopServices.buscarPorId(dto.workshopId());
        List<ColaboradorEntity> colaboradores = dto.colaboradoresIds().stream()
                .map(colaboradorServices::buscarPorId)
                .collect(Collectors.toList());

        AtaEntity ata = new AtaEntity(workshop, colaboradores);
        return ataRepository.save(ata);
    }


    public AtaEntity adicionarColaborador(Long ataId, Long colaboradorId) {
        AtaEntity ata = ataRepository.findById(ataId)
                .orElseThrow(() -> new AtaNotFoundException(ataId));

        ColaboradorEntity colaborador = colaboradorServices.buscarPorId(colaboradorId);

        if (ata.getColaboradores().contains(colaborador)) {
            throw new ColaboradorJaAdicionadoException(colaboradorId, ataId);
        }

        ata.getColaboradores().add(colaborador);
        return ataRepository.save(ata);
    }

    public AtaEntity removerColaborador(Long ataId, Long colaboradorId) {
        AtaEntity ata = ataRepository.findById(ataId)
                .orElseThrow(() -> new AtaNotFoundException(ataId));

        ColaboradorEntity colaborador = colaboradorServices.buscarPorId(colaboradorId);

        if (!ata.getColaboradores().contains(colaborador)) {
            throw new ColaboradorNaoPresenteException(colaboradorId, ataId);
        }

        ata.getColaboradores().remove(colaborador);
        return ataRepository.save(ata);
    }


    public List<Map<String, Object>> listarColaboradoresComWorkshops() {
        List<AtaEntity> atas = ataRepository.findAll();
        if (atas.isEmpty()) return  Collections.emptyList();

        Map<String, Set<String>> map = new TreeMap<>();
        for (AtaEntity ata : atas) {
            String workshopNome = ata.getWorkshop().getNome();
            for (ColaboradorEntity c : ata.getColaboradores()) {
                map.computeIfAbsent(c.getNome(), k -> new TreeSet<>())
                        .add(workshopNome);
            }
        }

        return map.entrySet().stream()
                .map(e -> Map.of(
                        "colaborador", e.getKey(),
                        "workshops", e.getValue()
                ))
                .toList();
    }


    public List<AtaEntity> buscarPorWorkshopNome(String nome) {
        return ataRepository.findAll().stream()
                .filter(ata -> ata.getWorkshop().getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }


    public List<AtaEntity> buscarPorData(LocalDate data) {
        return ataRepository.findAll().stream()
                .filter(ata -> data.equals(ata.getWorkshop().getDataRealizacao()))
                .toList();
    }
}
