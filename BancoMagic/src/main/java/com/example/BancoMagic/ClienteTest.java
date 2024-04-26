package com.example.BancoMagic;
import static org.junit.Assert.*;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void testConstrutorCliente() {
        Cliente cliente = new Cliente("João", "123.456.789-00", "123456789", "joao@example.com");
        assertEquals("João", cliente.getNome());
        assertEquals("123.456.789-00", cliente.getCpf());
        assertEquals("123456789", cliente.getTelefone());
        assertEquals("joao@example.com", cliente.getEmail());
        assertEquals(true, cliente.getContaMagicaCriada());
        cliente.getContaMagica().restartCount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstrutorClienteComParametrosNulos() {
        new Cliente(null, "123.456.789-00", "123456789", "joao@example.com");
    }

    //Testa se a conta inicia com o valor SILVER.
    @Test
    public void categoriaInicialTeste() {
        Cliente clienteInicial = new Cliente("Lucas", "123.456.789-00", "123456789", "lucas@example.com");
        assertEquals(Categoria.SILVER, clienteInicial.getContaMagica().getCategoria());
        clienteInicial.getContaMagica().restartCount();
    }

    @Test
    public void testaCriacaoConta() {
        Cliente clienteInicial = new Cliente("João Marcos", "123.456.789-00", "123456789", "joaomarcos@example.com");
        assertEquals(true, clienteInicial.getContaMagicaCriada());
        clienteInicial.getContaMagica().restartCount();
    }

    @Test
    public void testaContaMagicaReturn() {
        Cliente clienteInicial = new Cliente("João Pedro", "123.456.789-00", "123456789", "joaopedro@example.com");
        assertNotNull(clienteInicial.getContaMagica());
        clienteInicial.getContaMagica().restartCount();
    }

    @Test
    public void testToString() {
        Cliente clienteTestado = new Cliente("Guilherme", "123.456.789-00", "123456789", "gui@example.com");
        String esperado = "Informações da Conta - 1; Nome: Guilherme; CPF: 123.456.789-00; Telefone: 123456789; Email: gui@example.com; Categoria: SILVER; Saldo: 0.0";
        assertEquals(esperado, clienteTestado.toString());
        clienteTestado.getContaMagica().restartCount();
    }

    @Test
    public void testIdsContas() {
        Cliente cliente1 = new Cliente("Guilherme", "123.456.789-00", "123456789", "gui@example.com");
        Cliente cliente2 = new Cliente("Maria", "987.654.321-00", "987654321", "maria@example.com");
        Cliente cliente3 = new Cliente("João", "111.222.333-44", "111222333", "joao@example.com");
        Cliente cliente4 = new Cliente("Ana", "555.666.777-88", "555666777", "ana@example.com");
        Cliente cliente5 = new Cliente("Pedro", "999.888.777-66", "999888777", "pedro@example.com");
        Cliente cliente6 = new Cliente("Carla", "444.333.222-11", "444333222", "carla@example.com");

        Integer id1 = 1;
        assertEquals(id1, cliente1.getContaMagica().getIdConta());
        Integer id2 = 2;
        assertEquals(id2, cliente2.getContaMagica().getIdConta());
        Integer id3 = 3;
        assertEquals(id3, cliente3.getContaMagica().getIdConta());
        Integer id4 = 4;
        assertEquals(id4, cliente4.getContaMagica().getIdConta());
        Integer id5 = 5;
        assertEquals(id5, cliente5.getContaMagica().getIdConta());
        Integer id6 = 6;
        assertEquals(id6, cliente6.getContaMagica().getIdConta());

    }
}
