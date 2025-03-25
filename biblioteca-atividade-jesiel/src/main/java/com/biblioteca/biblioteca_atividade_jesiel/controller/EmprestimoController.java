package com.biblioteca.biblioteca_atividade_jesiel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca_atividade_jesiel.domain.empretismo.Emprestimo;
import com.biblioteca.biblioteca_atividade_jesiel.domain.empretismo.EmprestimoRepository;
import com.biblioteca.biblioteca_atividade_jesiel.domain.livro.Livro;
import com.biblioteca.biblioteca_atividade_jesiel.domain.livro.LivroRepository;
import com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.Usuario;
import com.biblioteca.biblioteca_atividade_jesiel.domain.usuario.UsuarioRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.biblioteca_atividade_jesiel.domain.empretismo.EmprestimoDto;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public EmprestimoController() {

    }

    public EmprestimoController(EmprestimoRepository emprestimoRepository, LivroRepository livroRepository,
            UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<Emprestimo> criarEmprestimo(@RequestBody @Valid EmprestimoDto emprestimoDto) {
        // Busca o livro e o usuário pelos IDs
        Livro livro = livroRepository.findById(emprestimoDto.livroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        Usuario usuario = usuarioRepository.findById(emprestimoDto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Cria o empréstimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro); // Usando setLivro
        emprestimo.setUsuario(usuario); // Usando setUsuario
        emprestimo.setDataEmprestimo(emprestimoDto.dataEmprestimo());
        emprestimo.setDataDevolucao(emprestimoDto.dataDevolucao());

        // Salva o empréstimo no banco de dados
        Emprestimo savedEmprestimo = emprestimoRepository.save(emprestimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmprestimo);
    }

    //listar emprestimos
    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarTodosEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoRepository.findAll();
        return ResponseEntity.ok(emprestimos);
    }

}
