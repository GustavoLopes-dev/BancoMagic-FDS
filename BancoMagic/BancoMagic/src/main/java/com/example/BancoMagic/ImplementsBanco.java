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
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public class Main {
        public static void main(String[] args) {
            ImplementsBanco banco = new ImplementsBanco();

            // Adicionar os 16 clientes
            banco.adicionarCliente(new Cliente("João", "111.111.111-11", "(11) 1111-1111", "joao@example.com"));
            banco.adicionarCliente(new Cliente("Maria", "222.222.222-22", "(22) 2222-2222", "maria@example.com"));
            banco.adicionarCliente(new Cliente("José", "333.333.333-33", "(33) 3333-3333", "jose@example.com"));
            banco.adicionarCliente(new Cliente("Ana", "444.444.444-44", "(44) 4444-4444", "ana@example.com"));
            banco.adicionarCliente(new Cliente("Carlos", "555.555.555-55", "(55) 5555-5555", "carlos@example.com"));
            banco.adicionarCliente(new Cliente("Mariana", "666.666.666-66", "(66) 6666-6666", "mariana@example.com"));
            banco.adicionarCliente(new Cliente("Pedro", "777.777.777-77", "(77) 7777-7777", "pedro@example.com"));
            banco.adicionarCliente(new Cliente("Camila", "888.888.888-88", "(88) 8888-8888", "camila@example.com"));
            banco.adicionarCliente(new Cliente("Lucas", "999.999.999-99", "(99) 9999-9999", "lucas@example.com"));
            banco.adicionarCliente(new Cliente("Juliana", "101.101.101-01", "(01) 1010-1010", "juliana@example.com"));
            banco.adicionarCliente(new Cliente("Felipe", "202.202.202-02", "(02) 2020-2020", "felipe@example.com"));
            banco.adicionarCliente(new Cliente("Fernanda", "303.303.303-03", "(03) 3030-3030", "fernanda@example.com"));
            banco.adicionarCliente(new Cliente("Rafael", "404.404.404-04", "(04) 4040-4040", "rafael@example.com"));
            banco.adicionarCliente(new Cliente("Patrícia", "505.505.505-05", "(05) 5050-5050", "patricia@example.com"));
            banco.adicionarCliente(new Cliente("Gustavo", "606.606.606-06", "(06) 6060-6060", "gustavo@example.com"));

            // Verificar se os clientes foram adicionados corretamente
            List<Cliente> clientes = banco.getClientes();
            for (Cliente cliente : clientes) {
                System.out.println(cliente.getNome());
            }
        }
    }
}


