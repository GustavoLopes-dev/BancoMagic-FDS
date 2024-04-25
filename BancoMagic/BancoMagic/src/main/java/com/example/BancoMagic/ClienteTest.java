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
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstrutorClienteComParametrosNulos() {
        new Cliente(null, "123.456.789-00", "123456789", "joao@example.com");
    }

    @Test
    public void testToString() {
        Cliente cliente = new Cliente("João", "123.456.789-00", "123456789", "joao@example.com");
        String expected = "Informações da Conta - 1; Nome: João; CPF: 123.456.789-00; Telefone: 123456789; Email: joao@example.com; Categoria: SILVER; Saldo: 0.0";
        assertEquals(expected, cliente.toString());
    }
}
