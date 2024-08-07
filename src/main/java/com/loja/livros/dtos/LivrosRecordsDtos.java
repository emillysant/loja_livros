package com.loja.livros.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivrosRecordsDtos(@NotBlank String titulo, @NotNull Double preco, @NotBlank String genero) {
}
