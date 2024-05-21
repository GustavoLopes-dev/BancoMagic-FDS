package com.example.BancoMagic.testes;

import static org.junit.Assert.*;

import com.example.BancoMagic.Categoria;
import com.example.BancoMagic.Cliente;
import com.example.BancoMagic.ContaMagica;
import org.junit.Test;

public class ContaMagicaTest {
    @Test(expected = IllegalArgumentException.class)
    public void testConstrutorTitularNulo() {
        Cliente clienteNulo = null;
        ContaMagica conta = new ContaMagica(clienteNulo); // Deve lançar uma exceção IllegalArgumentException
    }

    @Test
    public void testaCategoriaInicial() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        Categoria teste = Categoria.SILVER;
        assertEquals(teste, conta.getCategoria());
        conta.restartCount();
    }

    @Test
    public void testaIdInicial() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        Integer idEsperado = 1;
        assertEquals(idEsperado, conta.getIdConta());
        conta.restartCount();
    }

    @Test
    public void testaAtualizacaoId() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        Cliente clienteTesteDois = new Cliente("Filipe", "12345678900", "(51)999900178", "gustavoff@email.com");
        ContaMagica contaDois = clienteTesteDois.getContaMagica();
        Integer idEsperado2 = 2;
        assertEquals(idEsperado2, contaDois.getIdConta());
        conta.restartCount();
    }

    @Test
    public void testaTitular() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        String titularEsperado = "Gustavo";
        assertEquals(titularEsperado, conta.getTitular());
        conta.restartCount();
    }

    @Test
    public void testaTitularInfos() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        String esperado = "Informações da Conta - 1; Nome: Gustavo; CPF: 12345678900; Telefone: (51)999900178; "
                +"Email: gustavo@email.com; Categoria: SILVER; Saldo: 0.0";
        assertEquals(esperado, conta.getTitularInfos());
        conta.restartCount();
    }

    @Test
    public void testaSaldo() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        Float esperado = 0.0f;
        assertEquals(esperado, conta.getSaldo());
        conta.restartCount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testadepositoException() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        conta.deposito((float)-1.1);
        conta.restartCount();
    }

    @Test
    public void testadeposito() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        conta.deposito((float)10.0);
        float teste_value = (float)10.0;
        float valor = conta.getSaldo();
        assertEquals(valor, teste_value, 0.01);

        conta.deposito((float)24.0);
        float teste_sec_value = (float)34.0;
        float valor_sec = conta.getSaldo();
        assertEquals(valor_sec, teste_sec_value, 0.01);
        conta.restartCount();
    }

    @Test
    public void testaProgressao() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();

        // Depositar um valor próximo ao limite
        conta.deposito((float) 49_999.9);
        Categoria esperado = Categoria.SILVER;
        assertEquals(esperado, conta.getCategoria());

        // Verificar se a categoria permanece como SILVER após um novo depósito
        // mesmo depois de passar do limite de SILVER
        conta.deposito((float) 10.0);
        assertEquals(esperado, conta.getCategoria());
        conta.deposito((float) 50_000.00);
        esperado = Categoria.GOLD;
        assertEquals(esperado, conta.getCategoria());
        conta.deposito((float)120_000.00);
        esperado = Categoria.GOLD;
        assertEquals(esperado, conta.getCategoria());
        conta.deposito((float) 20.0);
        esperado = Categoria.PLATINUM;
        assertEquals(esperado, conta.getCategoria());
        conta.restartCount();
    }

    @Test
    public void testaProgressaoLinear() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        conta.deposito((float)200_000.00);
        Categoria esperado = Categoria.SILVER;
        assertEquals(esperado, conta.getCategoria());
        conta.deposito((float)1.05);
        esperado = Categoria.GOLD;
        assertEquals(esperado, conta.getCategoria());
        conta.deposito((float) 100.00);
        esperado = Categoria.PLATINUM;
        assertEquals(esperado, conta.getCategoria());
        conta.restartCount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaSaqueInvalido() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        conta.deposito((float)100_000.00);
        conta.saque((float)101_000.00);
        conta.restartCount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaSaqueNegativo() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        conta.deposito((float)100_000.00);
        conta.saque((float)-10_000);
        conta.restartCount();
    }

    @Test
    public void testaRegressaoDePerfil() {
        Cliente clienteTeste = new Cliente("Gustavo", "12345678900", "(51)999900178", "gustavo@email.com");
        ContaMagica conta = clienteTeste.getContaMagica();
        conta.deposito((float)50_000.00);

        Categoria esperado = Categoria.SILVER;
        assertEquals(esperado, conta.getCategoria());
        conta.deposito((float)1_000.00);

        esperado = Categoria.GOLD;
        assertEquals(esperado, conta.getCategoria());
        conta.deposito((float)160_000.00);
        assertEquals(esperado, conta.getCategoria());
        conta.saque((float)10_000.00);

        esperado = Categoria.PLATINUM;
        assertEquals(esperado, conta.getCategoria());
        conta.saque((float)70_000.00);

        esperado = Categoria.GOLD;
        assertEquals(esperado, conta.getCategoria());
        conta.saque((float)10.00);
        assertEquals(esperado, conta.getCategoria());
        conta.saque((float)80_000.00);
        assertEquals(esperado, conta.getCategoria());

        conta.saque((float)10_000.00);
        conta.saque((float)1_000.00);
        esperado = Categoria.SILVER;
        assertEquals(esperado, conta.getCategoria());
        conta.restartCount();
    }
}