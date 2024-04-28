package com.example.BancoMagic;

public class ContaMagica {
    private static Integer idContaControle = 0;
    private Integer idConta;
    private Float totalDep = 0.0f;
    private Categoria categoria; // Toda conta inicia como Silver
    private Cliente titular;
    private Float saldo;

    public ContaMagica(Cliente titular) {
        if (titular == null) {
            throw new IllegalArgumentException("O titular da conta não pode ser nulo.");
        }
        idContaControle++; // Incrementa o contador de ID
        idConta = idContaControle; // Atribui o ID da conta
        this.categoria = Categoria.SILVER; // Inicia como Silver por padrão
        this.titular = titular;
        this.saldo = 0.0f;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getTitular() {
        return titular.getNome();
    }

    public String getTitularInfos() {
        return titular.toString();
    }

    public Float getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Informações da Conta - " + idConta
                + "; Titular: " + titular.getNome() + "; CPF: " + titular.getCpf()
                + "; Categoria: " + categoria
                + "; Saldo: " + saldo;
    }

    public void deposito(float valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do deposito não pode ser negativo.");
        }

        updateAccount();
        switch (this.categoria) {
            case GOLD: depGold(valor); break;
            case PLATINUM: depPlatinum(valor); break;
            default: depSilver(valor); break;
        }
    }

    public void saque(float valor) {
        if (valor > getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar o saque.");
        }

        if (valor < 0) {
            throw new IllegalArgumentException("Valor de saque nao pode ser menor que zero.");
        }
        saldo -= valor;
        updateAccount();
    }

    private void updateAccount() {
        // Verifica se a conta atinge ou supera R$ 200.000,00 para ser atualizada para a categoria "Platinum"
        if (this.saldo >= 200_000.00 && this.categoria == Categoria.GOLD) {
            this.categoria = Categoria.PLATINUM;
        }
        else if(this.saldo >= 200_000.00 && this.categoria == Categoria.SILVER) {
            this.categoria = Categoria.GOLD;
        }
        // Verifica se a conta cai abaixo de R$ 200.000,00 para ser rebaixada de Platinum para Gold
        else if (this.saldo < 200_000.00 && this.categoria == Categoria.PLATINUM) {
            this.categoria = Categoria.GOLD;
        }
        // Verifica se a conta atinge ou supera R$ 50.000,00 para ser atualizada para a categoria "Gold"
        else if (this.saldo >= 50_000.00 && this.saldo < 200_000.00 && (this.categoria == Categoria.SILVER || this.categoria == Categoria.PLATINUM)) {
            this.categoria = Categoria.GOLD;
        }
        // Verifica se a conta cai abaixo de R$ 50.000,00 para ser rebaixada de Gold para Silver
        else if (this.saldo < 50_000.00 && this.categoria == Categoria.GOLD) {
            this.categoria = Categoria.SILVER;
        }
    }


    private void depSilver(float valor) {
        saldo += valor;
        totalDep += valor;
    }

    private void depGold(float valor) {
        // Valoriza o depósito em 1%
        saldo += valor * 1.01f;
        totalDep += valor;
    }

    private void depPlatinum(float valor) {
        // Valoriza o depósito em 2,5%
        saldo += valor * 1.025f;
        totalDep += valor;
    }

    //Criado apenas com o intuito de reiniciar o id de cada cliente para os casos de teste unitário.
    public void restartCount() {
        idContaControle = 0;
    }

}
