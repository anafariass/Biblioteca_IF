package com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, unique = true)
    private String autor;

    @Column(nullable = false, unique = true)
    private boolean disponivel;

    @Column(nullable = false)
    private int anoPublicacao;

    public Livro() {
    }

    public Livro(Long isbn, String titulo, String autor, boolean disponivel, int anoPublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.anoPublicacao = anoPublicacao;
    }

    public Livro(LivroDto dados) {
    }


    public Long getIsbn() {
        return isbn;
    }
    public void setIsbn(Long isbn) {
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

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

}
