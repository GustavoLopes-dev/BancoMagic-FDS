package com.example.BancoMagic;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private ContaMagica contaMagica; // Adicionando referência para ContaMagica

    public Cliente(String nome, String cpf, String telefone, String email) {
        if (nome != null && cpf != null && telefone != null && email != null) {
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.email = email;
            // Criar uma nova ContaMagica para este cliente
            this.contaMagica = new ContaMagica(this);
        } else {
            throw new IllegalArgumentException("Os parâmetros não podem ser nulos.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public ContaMagica getContaMagica() {
        return contaMagica;
    }

    @Override
    public String toString() {
        return "Informações da Conta - " + contaMagica.getIdConta()
                + "\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nTelefone: " + getTelefone()
                + "\nEmail: " + getEmail()
                + "\nCategoria: " + contaMagica.getCategoria()
                + "\nSaldo: " + contaMagica.getSaldo();
    }
}
