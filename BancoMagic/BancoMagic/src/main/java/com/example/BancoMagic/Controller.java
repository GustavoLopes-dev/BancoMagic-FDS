package com.example.BancoMagic;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private ImplementsBanco bancoContas;

    public Controller(ImplementsBanco bancoContas) {
        this.bancoContas = bancoContas;
    }

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

    @GetMapping("/clientes")
    @CrossOrigin(origins = "*")
    public List<Cliente> getListaClientes() {
        return bancoContas.getClientes();
    }


}
