package com.example.BancoMagic;

import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/clientes")
    @CrossOrigin(origins = "*")
    public List<Cliente> getListaClientes() {
        return bancoContas.getClientes();
    }

    @GetMapping("/clientesSize")
    @CrossOrigin(origins = "*")
    public int getTotalClientes() {
        return bancoContas.quantidadeClientes();
    }

    @PostMapping("/clientesCadastro")
    @CrossOrigin(origins = "*")
    public boolean setCadastraCliente(@RequestBody Cliente novo) {
        bancoContas.adicionarCliente(novo);
        return true;
    }
}
