package com.example.BancoMagic;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import java.util.List;

public class ContaMagicaTest {
    //Conta para teste geral, instanciada da maneira correta.
    static int testes = 0;
    Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
    ContaMagica conta = clienteTeste.getContaMagica();


    @Test
    public void testaCategoriaInicial() {
        Categoria teste = Categoria.SILVER;
        assertEquals(teste, clienteTeste.getContaMagica().getCategoria());
        clienteTeste.getContaMagica().restartCount();
    }

    @Test
    public void testaIdInicial() {
        Integer idEsperado = 1;
        assertEquals(idEsperado, clienteTeste.getContaMagica().getIdConta());
        clienteTeste.getContaMagica().restartCount();
    }

    @Test
    public void testaAtualizacaoId() {
        Cliente clienteTesteDois = new Cliente("Filipe", "12345678900", "(51)999900178", "gustavoff@email.com");
        ContaMagica contaDois = clienteTesteDois.getContaMagica();
        Integer idEsperado2 = 2;
        assertEquals(idEsperado2, contaDois.getIdConta());
    }

    @Test
    public void testaTitular() {
        String titularEsperado = "Gustavo";
        assertEquals(titularEsperado, conta.getTitular());
    }

    @Test
    public void testaTitularInfos() {
        String esperado = "Informações da Conta - 1; Nome: Gustavo; CPF: 12345678900; Telefone: (51)999900178; "
                        +"Email: gustavo@email.com; Categoria: SILVER; Saldo: 0.0";
        assertEquals(esperado, conta.getTitularInfos());
    }

    @Test
    public void testaSaldo() {
        Float esperado = 0.0f;
        assertEquals(esperado, conta.getSaldo());
    }


}
