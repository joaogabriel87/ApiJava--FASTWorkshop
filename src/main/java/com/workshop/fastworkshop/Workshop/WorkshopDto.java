package com.workshop.fastworkshop.Workshop;

import com.workshop.fastworkshop.Colaboradores.ColaboradorDto;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record WorkshopDto(
         @NotBlank String nome, LocalDate dataRealizacao, @NotBlank String descricao, List<String> colaboradores

) {
}
