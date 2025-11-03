package com.workshop.fastworkshop.Colaboradores;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "colaboradores")
public class ColaboradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public ColaboradorEntity(String nome ) {
        this.nome = nome;
    }
}
