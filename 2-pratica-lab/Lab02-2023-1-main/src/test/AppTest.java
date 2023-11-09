package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import array.ListaArray;
import list.EstruturaElementar;

public class AppTest {

    private EstruturaElementar e;

    @Before
    public void setUp() throws Exception {
        e = new ListaArray();
    }

    @Test
    public void testInsereInicio() {
        e.insereInicio(0);
        assertEquals("Não é o primeiro " + 0, e.buscaIndice(0), 0);
        e.insereInicio(1);
        assertEquals("Não é o primeiro " + 1, e.buscaIndice(0), 1);
        e.insereInicio(2);
        assertEquals("Não é o primeiro " + 2, e.buscaIndice(0), 2);
        e.insereInicio(3);
        assertEquals("Não é o primeiro " + 3, e.buscaIndice(0), 3);
        assertTrue("Não encontrado " + 0, e.buscaElemento(0));
        assertTrue("Não encontrado " + 1, e.buscaElemento(1));
        assertTrue("Não encontrado " + 2, e.buscaElemento(2));
        assertTrue("Não encontrado " + 3, e.buscaElemento(3));

        assertFalse("Encontrado " + 5, e.buscaElemento(5));
        assertFalse("Encontrado " + -1, e.buscaElemento(-1));
    }
    
    @Test
    public void testInsereFim() {
        e.insereFim(0);
        assertEquals("Não é o primeiro " + 0, e.buscaIndice(0), 0);
        e.insereFim(1);
        assertEquals("Não é o primeiro " + 1, e.buscaIndice(1), 1);
        e.insereFim(2);
        assertEquals("Não é o primeiro " + 2, e.buscaIndice(2), 2);
        e.insereFim(3);
        assertEquals("Não é o primeiro " + 3, e.buscaIndice(3), 3);
        assertTrue("Não encontrado " + 0, e.buscaElemento(0));
        assertTrue("Não encontrado " + 1, e.buscaElemento(1));
        assertTrue("Não encontrado " + 2, e.buscaElemento(2));
        assertTrue("Não encontrado " + 3, e.buscaElemento(3));

        assertFalse("Encontrado " + 5, e.buscaElemento(5));
        assertFalse("Encontrado " + -1, e.buscaElemento(-1));
    }

    @Test
    public void testInsere() {
        assertFalse("Encontrado " + -1, e.buscaElemento(-1));
        e.insereElemento(0);
        e.insereElemento(1);
        e.insereElemento(2);
        e.insereElemento(3);
        assertTrue("Não encontrado " + 0, e.buscaElemento(0));
        assertTrue("Não encontrado " + 1, e.buscaElemento(1));
        assertTrue("Não encontrado " + 2, e.buscaElemento(2));
        assertTrue("Não encontrado " + 3, e.buscaElemento(3));

        assertFalse("Encontrado " + 5, e.buscaElemento(5));
        assertFalse("Encontrado " + -1, e.buscaElemento(-1));
    }

    @Test
    public void testRemove() {
        e.insereElemento(0);
        e.insereElemento(1);
        e.insereElemento(2);
        e.insereElemento(3);
        assertTrue("Não encontrado " + 0, e.buscaElemento(0));
        assertTrue("Não encontrado " + 1, e.buscaElemento(1));
        assertTrue("Não encontrado " + 2, e.buscaElemento(2));
        assertTrue("Não encontrado " + 3, e.buscaElemento(3));

        e.remove(3);
        e.remove(5);
        e.remove(-1);
        assertFalse("Encontrado " + 3, e.buscaElemento(3));
        assertFalse("Encontrado " + 5, e.buscaElemento(5));
        assertFalse("Encontrado " + -1, e.buscaElemento(-1));
        e.remove(3);
        assertFalse("Encontrado " + 3, e.buscaElemento(3));
    }

    @Test
    public void testRemoveInicio() {
        e.removeInicio();
        e.insereInicio(0);
        e.insereInicio(1);
        e.insereInicio(2);
        e.insereInicio(3);
        assertEquals("Não encontrado " + 3, 3, e.buscaIndice(0));

        e.removeInicio();
        assertFalse("Encontrado " + 3, e.buscaElemento(3));
        assertEquals("Inicio é " + 2, 2, e.buscaIndice(0));
    }

    @Test
    public void testRemoveFim() {
        e.removeFim();
        e.insereInicio(0);
        e.insereInicio(1);
        e.insereInicio(2);
        e.insereInicio(3);
        assertEquals("Não encontrado " + 3, 3, e.buscaIndice(0));
        e.removeFim();
        assertFalse("Encontrado " + 0, e.buscaElemento(0));
        assertTrue("Encontrado " + 3, e.buscaElemento(3));
        assertEquals("O ultimo é zero " + 0, 0, e.buscaIndice(2));
    }

    @Test
    public void testRemoveInserePosicao() {
        e.insereInicio(0);
        e.insereInicio(1);
        e.insereInicio(2);
        e.insereInicio(3);
        e.insereElementoPosicao(5, 0);
        assertTrue(e.buscaElemento(5));
        assertEquals(5, e.buscaIndice(0));
        e.removeIndice(0);
        assertFalse(e.buscaElemento(5));
        assertEquals(3, e.buscaIndice(0));
    }

    @Test
    public void testMaxMin() {
        e.insereInicio(0);
        e.insereInicio(1);
        e.insereInicio(2);
        e.insereInicio(3);
        assertEquals(3, e.maximo());
        assertEquals(0, e.minimo());
        e.insereElemento(10);
        e.insereElemento(-10);
        assertEquals(10, e.maximo());
        assertEquals(-10, e.minimo());
    }
}
