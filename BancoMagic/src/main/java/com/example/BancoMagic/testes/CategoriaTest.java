package com.example.BancoMagic.testes;

import static org.junit.Assert.*;

import com.example.BancoMagic.Categoria;
import org.junit.Test;

public class CategoriaTest {

    /**
     * Testa se os valores das constantes da enumeração estão configurados corretamente.
     */
    @Test
    public void testEnumValores() {
        Categoria silver = Categoria.SILVER;
        Categoria gold = Categoria.GOLD;
        Categoria platinum = Categoria.PLATINUM;

        assertEquals("SILVER", silver.name());
        assertEquals("GOLD", gold.name());
        assertEquals("PLATINUM", platinum.name());
    }

    /**
     * Testa se as constantes da enumeração estão na ordem correta.
     */
    @Test
    public void testEnumOrdem() {
        Categoria[] categorias = Categoria.values();

        assertEquals(Categoria.SILVER, categorias[0]);
        assertEquals(Categoria.GOLD, categorias[1]);
        assertEquals(Categoria.PLATINUM, categorias[2]);
    }

    /**
     * Testa se o método toString() retorna a representação textual correta para cada constante da enumeração.
     */
    @Test
    public void testEnumToString() {
        Categoria silver = Categoria.SILVER;
        Categoria gold = Categoria.GOLD;
        Categoria platinum = Categoria.PLATINUM;

        assertEquals("SILVER", silver.toString());
        assertEquals("GOLD", gold.toString());
        assertEquals("PLATINUM", platinum.toString());
    }
}

