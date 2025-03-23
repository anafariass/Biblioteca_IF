package com.biblioteca.biblioteca_atividade_jesiel.domain.empretismo;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record EmprestimoDto(@NotNull Long id, @NotNull Long livroId, @NotNull UUID usuarioId, @NotNull LocalDate dataEmprestimo, @NotNull LocalDate dataDevolucao) {
    
    
}
