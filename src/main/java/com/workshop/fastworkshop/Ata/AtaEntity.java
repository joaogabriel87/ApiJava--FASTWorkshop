package com.workshop.fastworkshop.Ata;

import com.workshop.fastworkshop.Colaboradores.ColaboradorEntity;
import com.workshop.fastworkshop.Workshop.WorkshopEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ata")
public class AtaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workshop_id", nullable = false)
    private WorkshopEntity workshop;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ata_colaboradores",
            joinColumns = @JoinColumn(name = "ata_id"),
            inverseJoinColumns = @JoinColumn(name = "colaborador_id")
    )
    private List<ColaboradorEntity> colaboradores;

    public AtaEntity() {}
    public AtaEntity( WorkshopEntity workshop, List<ColaboradorEntity> colaboradores ) {
        this.workshop = workshop;
        this.colaboradores = colaboradores;
    }
}
