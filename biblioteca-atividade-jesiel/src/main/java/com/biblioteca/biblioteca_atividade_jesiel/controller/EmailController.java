package com.biblioteca.biblioteca_atividade_jesiel.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca_atividade_jesiel.service.EmailService;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/enviar-email")
    public String enviarEmail(@RequestParam String destinatario, 
                              @RequestParam String livro, 
                              @RequestParam String data) {
        LocalDate dataDevolucao = LocalDate.parse(data);
        emailService.enviarLembreteDevolucao(destinatario, livro, dataDevolucao);
        return "E-mail enviado para " + destinatario + " sobre o livro '" + livro + "'!";
    }
}
