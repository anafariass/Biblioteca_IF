package com.biblioteca.biblioteca_atividade_jesiel.domain.usuario;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    
    
}
