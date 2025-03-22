package com.biblioteca.biblioteca_atividade_jesiel.domain.livro;

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

    @Column(nullable = false)
    private String editora;

    @Column(nullable = false, unique = true)
    private boolean disponivel;

    @Column(nullable = false)
    private int anoPublicacao;

    @Column(nullable = false)
    private int quantidade;



    public Livro() {
    }

    public Livro(Long isbn, String titulo, String autor, String editora, boolean disponivel, int anoPublicacao, int quantidade) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.disponivel = disponivel;
        this.anoPublicacao = anoPublicacao;
        this.quantidade = quantidade;
    }

    public Livro(LivroDto dados) {
        this.titulo = dados.titulo();
        this.autor = dados.autor();
        this.editora = dados.editora();
        this.disponivel = dados.disponivel();;
        this.anoPublicacao = dados.anoPublicacao();
        this.quantidade = dados.quantidade();

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

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
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

    public void setQuantidade(int quantidade) {
        this.anoPublicacao = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
