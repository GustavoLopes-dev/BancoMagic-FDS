package com.example.BancoMagic;

public class ContaMagica {
    private static Integer idContaControle = 0;
    private static Float totalDep = 0.0f;
    private Categoria categoria; // Toda conta inicia como Silver
    private Integer idConta;
    private Cliente titular;
    private Float saldo;

    public ContaMagica(Cliente titular) {
        if (idContaControle == 0) {
            idContaControle++;
            idConta = idContaControle;
        } else {
            idContaControle++;
            idConta = idContaControle;
        }
        this.categoria = Categoria.SILVER; // Inicia como Silver por padrão
        this.titular = titular;
        this.saldo = 0.0f;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public String getCategoria() {
        return categoria.toString();
    }
    public String getTitular() {
        return titular.toString();
    }
    public Float getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Informações da Conta - " + idConta
                + "\nTitular: " + titular.getNome() + "\nCPF do Titular: " + titular.getCpf()
                + "\nCategoria: " + categoria
                + "\nSaldo: " + saldo;
    }

    public void Deposito(float valor) {
        updateAccount();
        switch (categoria) {
            case GOLD: depGold(valor); break;
            case PLATINUM: depPlatinum(valor); break;
            default: depSilver(valor); break;
        }
    }

    public void Saque(float valor) {
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

    public void depSilver(float valor) {
        saldo += valor;
        totalDep += valor;
    }

    public void depGold(float valor) {
        saldo += valor*1.1f;
        totalDep += valor*1.1f;
    }

    public void depPlatinum(float valor) {
        saldo += valor*1.25f;
        totalDep += valor*1.25f;
    }

}
