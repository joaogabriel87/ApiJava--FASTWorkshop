package com.workshop.fastworkshop.Colaboradores;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Long> {
    boolean existsByNomeIgnoreCase(String nome);
}
