package com.bobds.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarVerificacion(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Verificá tu cuenta - BODS");
        message.setText("Tu código de verificación es: " + token +
                "\n\nO hacé click aquí: http://localhost:8081/api/auth/verify?token=" + token);
        mailSender.send(message);
    }
}