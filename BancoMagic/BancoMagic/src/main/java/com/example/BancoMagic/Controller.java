package com.example.BancoMagic;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem-vindo";
    }

    @GetMapping("/viadinho")
    @CrossOrigin(origins = "*")
    public String mensagemDeViado() {
        return "Bem-vindo viado";
    }


}
