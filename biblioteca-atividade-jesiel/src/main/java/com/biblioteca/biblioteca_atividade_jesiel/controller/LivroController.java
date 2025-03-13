package com.biblioteca.biblioteca_atividade_jesiel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.livro.Livro;
import com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.livro.LivroDto;
import com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.livro.LivroRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository LivroRepository;

    @PostMapping("/{isbn}")
    public ResponseEntity<Livro> criarLivro(@RequestBody @Valid LivroDto dados) {
        Livro livro = new Livro(dados);
        this.LivroRepository.save(livro);
        return ResponseEntity.ok(livro);

    }

    @GetMapping("/{isbn}")
    public ResponseEntity<?> selecionarPorId(@RequestParam Long isbn) {
        Livro livro = this.LivroRepository.findById(isbn).orElse(null);
        if(livro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livro);

    }
    
    
    @GetMapping
    public ResponseEntity<?> selecionarTodosLivros() {
        return ResponseEntity.ok(this.LivroRepository.findAll());

    }

}


