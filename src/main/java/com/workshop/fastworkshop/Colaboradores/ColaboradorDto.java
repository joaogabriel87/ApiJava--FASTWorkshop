package com.workshop.fastworkshop.Colaboradores;

import jakarta.validation.constraints.NotBlank;

public record ColaboradorDto(
         @NotBlank String nome
) {
}
