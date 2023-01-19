package com.UserPost.Project.controller;

import com.UserPost.Project.services.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fit4compite/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(path = "/enviar")
    public void enviarCorreo() {
        emailService.enviarMail(
                "asuntossaul@gmail.com",
                "prueba1",
                "holi uwu");
        System.out.println("correo enviado");
    }
}
