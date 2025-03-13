package com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroDto(@NotBlank String titulo, @NotBlank String autor, @NotBlank int anoPublicacao) {

    }
    
