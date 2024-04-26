package com.example.BancoMagic;

import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {
    private ImplementsBanco bancoContas;

    private final RestTemplate restTemplate;


    public Controller(ImplementsBanco bancoContas) {
        this.bancoContas = bancoContas;
        this.restTemplate = new RestTemplate();
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
        return true; // ou alguma lógica para indicar se o cliente foi cadastrado com sucesso
    }

    @GetMapping("/teste-cep")
    @CrossOrigin
    public Object consultaCep(){
        String url = "https://brasilapi.com.br/api/cep/v1/" + "91450030";
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/teste-cnpj")
    @CrossOrigin
    public Object consultaCNPJ(){
        String url = "https://brasilapi.com.br/api/cnpj/v1/" + "35337331000104";
        return restTemplate.getForObject(url, CNPJ.class);
    }


}
