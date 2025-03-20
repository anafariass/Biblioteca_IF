package com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.livro;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LivroDto(@NotBlank String titulo, @NotBlank String autor,@NotBlank String editora, Boolean disponivel, @NotNull @Min(1000) @Max(9999) Integer anoPublicacao,@NotNull @Positive Integer quantidade) {


    }
    
