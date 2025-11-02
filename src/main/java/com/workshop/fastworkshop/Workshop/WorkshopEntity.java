package com.workshop.fastworkshop.Workshop;

import com.workshop.fastworkshop.Colaboradores.ColaboradorEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "workshops")
public class WorkshopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataRealizacao;
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "workshop_colaboradores",
            joinColumns = @JoinColumn(name = "workshop_id"),
            inverseJoinColumns = @JoinColumn(name = "colaborador_id")
    )
    private List<ColaboradorEntity> colaboradores;

    public WorkshopEntity() {}
    public WorkshopEntity(String nome, LocalDate dataRealizacao, String descricao) {
        this.nome = nome;
        this.dataRealizacao = dataRealizacao;
        this.descricao = descricao;
    }
}
