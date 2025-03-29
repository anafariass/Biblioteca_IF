package com.biblioteca.biblioteca_atividade_jesiel.service;

import java.time.LocalDate;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarLembreteDevolucao(String destinatario, String livroTitulo, LocalDate dataDevolucao) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(destinatario);
        email.setSubject("📚 Lembrete de Devolução - Biblioteca");
        email.setText(
            "Olá!\n\n" +
            "Você tem o livro \"" + livroTitulo + "\" para devolver até " + dataDevolucao + ".\n\n" +
            "Evite multas! 😊\n\n" +
            "Atenciosamente,\nEquipe da Biblioteca"
        );
        mailSender.send(email);
    }
}