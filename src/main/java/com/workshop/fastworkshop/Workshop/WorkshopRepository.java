package com.workshop.fastworkshop.Workshop;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WorkshopRepository extends JpaRepository<WorkshopEntity, Long> {
    List<WorkshopEntity> findByNomeContainingIgnoreCase(String nome);

    List<WorkshopEntity> findByDataRealizacao(LocalDate data);

    boolean existsByNomeAndDataRealizacao(String nome, LocalDate dataRealizacao);
}
