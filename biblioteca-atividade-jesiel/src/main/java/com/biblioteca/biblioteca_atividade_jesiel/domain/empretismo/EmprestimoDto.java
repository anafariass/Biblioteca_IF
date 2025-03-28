package com.biblioteca.biblioteca_atividade_jesiel.domain.empretismo;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record EmprestimoDto(Long id, @NotNull Long isbn, @NotNull UUID usuarioId, @NotNull LocalDate dataEmprestimo, LocalDate dataDevolucao) {
    
    
}
