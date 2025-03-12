package com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.livro;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity

public class Livro {
     @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID isbn;

    @Column(nullable = false)
    @NotBlank(message = "O campo titulo é obrigatório")// notblank "verifica" se está vazio.
    private String titulo;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O campo autor é obrigatório")
    private String autor;

    @Column(nullable = false, unique = true)
    private boolean disponivel;

    public UUID getIsbn() {
        return isbn;
    }
    public void setIsbn(UUID isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }  
    public  void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
