package com.biblioteca.biblioteca_atividade_jesiel.controller;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.Usuario;
import com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.UsuarioDto;
import com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository UsuarioRepository;

    //criação de usuarios
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid  UsuarioDto dados){
    Usuario usuarioCriado  = new Usuario(dados);
    this.UsuarioRepository.save(usuarioCriado);

    return ResponseEntity.ok(usuarioCriado);

    }

    //selecçao de usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> selecionarTodosusuarios(){
        List<Usuario> usuarios = this.UsuarioRepository.findAll();

        return ResponseEntity.ok(usuarios);
    }

    //selecao por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> selecionarUsuarioPorId(@PathVariable UUID id){
        Usuario usuario = this.UsuarioRepository.findById(id).orElse(null);

        if(usuario == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

    //atualização de usuarios
    // put é utilizado para atualizar todos os campos(usuario por inteiro)
    //patch atualiza apenas um campo (especifico)
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable UUID id, @RequestBody UsuarioDto dados){
        Usuario usuario = this.UsuarioRepository.findById(id).orElse(null);

        if(usuario == null){
            return ResponseEntity.notFound().build();
        }

        usuario.setNome(dados.nome());
        usuario.setEmail(dados.email());

        this.UsuarioRepository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    //deleção de usuarios
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable UUID id){
        Usuario usuario = this.UsuarioRepository.findById(id).orElse(null);

        if(usuario == null){
            return ResponseEntity.notFound().build();
        }

        this.UsuarioRepository.delete(usuario);

        return ResponseEntity.ok("Usuario " +usuario.getNome() + " deletado com sucesso");
    }
}
