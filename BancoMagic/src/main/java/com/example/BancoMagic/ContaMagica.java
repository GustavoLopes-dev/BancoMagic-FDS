package com.example.BancoMagic;

public class ContaMagica {
    private static Integer idContaControle = 0;
    private Float totalDep = 0.0f;
    private Categoria categoria; // Toda conta inicia como Silver
    private Integer idConta;
    private Cliente titular;
    private Float saldo;

    public ContaMagica(Cliente titular) {
        if (titular == null) {
            throw new IllegalArgumentException("O titular da conta não pode ser nulo.");
        }
        if (idContaControle == 0) {
            idContaControle++;
            idConta = this.idContaControle;
        } else {
            idContaControle++;
            idConta = this.idContaControle;
        }
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

    public void Deposito(float valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do deposito não pode ser negativo.");
        }

        switch (categoria) {
            case GOLD: depGold(valor); break;
            case PLATINUM: depPlatinum(valor); break;
            default: depSilver(valor); break;
        }
        updateAccount();
    }

    public void Saque(float valor) {
        if (valor > getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar o saque.");
        }
        saldo -= valor;
        updateAccount();
    }

    public void updateAccount() {
        if ((this.saldo >= 50.000 && this.saldo < 200.000) && (this.categoria == Categoria.SILVER)) {
            this.categoria = Categoria.GOLD;
        } if (this.saldo >= 200.000 && this.categoria == Categoria.GOLD) {
            this.categoria = Categoria.PLATINUM;
        } else {
            this.categoria = Categoria.SILVER;
        }
    }

    private void depSilver(float valor) {
        saldo += valor;
        totalDep += valor;
    }

    private void depGold(float valor) {
        saldo += valor*1.1f;
        totalDep += valor*1.1f;
    }

    private void depPlatinum(float valor) {
        saldo += valor*1.25f;
        totalDep += valor*1.25f;
    }

    //Criado apenas com o intuito de reiniciar o id de cada cliente para os casos de teste unitário.
    public void restartCount() {
        idContaControle = 0;
    }
}
