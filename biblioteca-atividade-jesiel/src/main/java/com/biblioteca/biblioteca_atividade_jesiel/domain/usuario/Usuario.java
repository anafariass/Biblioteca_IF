package com.biblioteca.biblioteca_atividade_jesiel.domain.usuario;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //representa uma tabela no banco de dados.

public class Usuario {
    @Id //chave primária da tabela
    @GeneratedValue(strategy = GenerationType.UUID) // define como será gerdado e gerar automaticamente como \ uuid - identificador único universal)
    private UUID id;

    @Column(nullable = false)// aqui gera as colunas da tabela
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;


    //getters e setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //construtir vazio e um com todos os argumentos
    public Usuario() {
    }
    
    //construtor com todos os argumentos
    public Usuario(UUID id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    //construtor com um argumento de UsuarioDto
    public Usuario(UsuarioDto usuarioDto){
        this.nome = usuarioDto.nome();
        this.email = usuarioDto.email();
    }
    
    
    
    
}
