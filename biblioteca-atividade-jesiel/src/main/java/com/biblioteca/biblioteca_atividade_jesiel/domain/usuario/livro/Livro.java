package com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.livro;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Livro {
     @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, unique = true)
    private String autor;

    @Column(nullable = false, unique = true)
    private boolean disponivel;
}
