package com.biblioteca.biblioteca_atividade_jesiel.domain.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LivroDto(@NotBlank String titulo, @NotBlank String autor,@NotBlank String editora,@NotNull Boolean disponivel, @NotNull Integer anoPublicacao,@NotNull @Positive Integer quantidade) {


    }
    
