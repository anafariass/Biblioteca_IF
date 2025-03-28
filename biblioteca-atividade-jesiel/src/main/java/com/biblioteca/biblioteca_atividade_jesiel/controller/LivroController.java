package com.biblioteca.biblioteca_atividade_jesiel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca_atividade_jesiel.domain.livro.Livro;
import com.biblioteca.biblioteca_atividade_jesiel.domain.livro.LivroDto;
import com.biblioteca.biblioteca_atividade_jesiel.domain.livro.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;



@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    
    //criar livros
    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody @Valid LivroDto dados) {
        Livro livro = new Livro(dados);
        this.livroRepository.save(livro);
        return ResponseEntity.ok(livro);

    }

    //selecionar livros por id
    @GetMapping("/{isbn}")
    public ResponseEntity<?> selecionarPorId(@PathVariable Long isbn) {
        Livro livro = this.livroRepository.findById(isbn).orElse(null);
        if(livro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livro);

    }
    
    //selecionar todos os livros
    @GetMapping
    public ResponseEntity<?> selecionarTodosLivros() {
        return ResponseEntity.ok(this.livroRepository.findAll());

    }

    //atualizar livros
    @PutMapping("/{isbn}")
    public ResponseEntity<?> atualizarLivro(@PathVariable Long isbn,@Valid @RequestBody LivroDto dados) {
        
        Livro livro = this.livroRepository.findById(isbn).orElse(null);
        if(livro == null){
            return ResponseEntity.notFound().build();
        }

        livro.setTitulo(dados.titulo());
        livro.setAutor(dados.autor());
        livro.setAnoPublicacao(dados.anoPublicacao());
        livro.setEditora(dados.editora());
        livro.setQuantidade(dados.quantidade());

        if(dados.disponivel() != null) {
            livro.setDisponivel(dados.disponivel());
        }

        this.livroRepository.save(livro);
        return ResponseEntity.ok(livro);

    }

    //delete livros
    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long isbn) {
        Livro livro = this.livroRepository.findById(isbn).orElse(null);
        if(livro == null){
            return ResponseEntity.notFound().build();
        }
        this.livroRepository.delete(livro);
        return ResponseEntity.ok("Livro " +livro.getTitulo() + " deletado com sucesso");

    }

}


