package com.example.BancoMagic;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContaMagicaTest {
    //Conta para teste geral, instanciada da maneira correta.
    Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
    ContaMagica conta = clienteTeste.getContaMagica();

    @Test(expected = IllegalArgumentException.class)
    public void testConstrutorTitularNulo() {
        Cliente clienteNulo = null;
        ContaMagica conta = new ContaMagica(clienteNulo); // Deve lançar uma exceção IllegalArgumentException
    }

    @Test
    public void testaCategoriaInicial() {
        Categoria teste = Categoria.SILVER;
        assertEquals(teste, clienteTeste.getContaMagica().getCategoria());
        conta.restartCount();
    }

    @Test
    public void testaIdInicial() {
        Integer idEsperado = 1;
        assertEquals(idEsperado, conta.getIdConta());
    }

    @Test
    public void testaAtualizacaoId() {
        Cliente clienteTesteDois = new Cliente("Filipe", "12345678900", "(51)999900178", "gustavoff@email.com");
        ContaMagica contaDois = clienteTesteDois.getContaMagica();
        Integer idEsperado2 = 2;
        assertEquals(idEsperado2, contaDois.getIdConta());
        contaDois.restartCount();
    }

    @Test
    public void testaTitular() {
        String titularEsperado = "Gustavo";
        assertEquals(titularEsperado, conta.getTitular());
        conta.restartCount();
    }

    @Test
    public void testaTitularInfos() {
        String esperado = "Informações da Conta - 1; Nome: Gustavo; CPF: 12345678900; Telefone: (51)999900178; "
                        +"Email: gustavo@email.com; Categoria: SILVER; Saldo: 0.0";
        assertEquals(esperado, conta.getTitularInfos());
        conta.restartCount();
    }

    @Test
    public void testaSaldo() {
        Float esperado = 0.0f;
        assertEquals(esperado, conta.getSaldo());
        conta.restartCount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaDepositoException() {
        conta.Deposito((float)-1.1);
    }

    @Test
    public void testaDeposito() {
        conta.Deposito((float)10.0);
        float teste_value = (float)10.0;
        float valor = conta.getSaldo();
        assertEquals(valor, teste_value, 0.01);
    }


}
