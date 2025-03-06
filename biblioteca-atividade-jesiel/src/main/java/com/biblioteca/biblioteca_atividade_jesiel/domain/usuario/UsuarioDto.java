package com.biblioteca.biblioteca_atividade_jesiel.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record UsuarioDto(@NotBlank String nome, @NotBlank @Email String email) {
    
}
