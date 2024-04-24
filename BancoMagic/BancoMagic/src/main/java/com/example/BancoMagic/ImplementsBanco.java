package com.example.BancoMagic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class ImplementsBanco {
    private List<Cliente> clientes;

    public ImplementsBanco() {
        this.clientes = new ArrayList<>();
        Cliente novo = new Cliente("João", "111.111.111-11", "(11) 1111-1111", "joao@example.com");
        this.clientes.add(novo);
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public int quantidadeClientes() {
        return this.clientes.size();
    }
}


