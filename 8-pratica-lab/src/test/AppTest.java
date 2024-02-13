package test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tree.BinarySearchTree;

public class AppTest {

    @Test
    public void inserir() {
        BinarySearchTree b = new BinarySearchTree();
        b.insereElemento(1);
        b.insereElemento(2);
        assertEquals(true, b.buscaElemento(1));
        assertEquals(true, b.buscaElemento(2));
        assertEquals(false, b.buscaElemento(3));
        assertArrayEquals(new int[]{1,2}, b.emOrdem());
    }


    @Test
    public void remover() {
        BinarySearchTree b = new BinarySearchTree();
        b.insereElemento(1);
        b.insereElemento(2);
        assertArrayEquals(new int[]{1,2}, b.emOrdem());
        b.remove(2);
        assertArrayEquals(new int[]{1}, b.emOrdem());
        assertEquals(true, b.buscaElemento(1));
        assertEquals(false, b.buscaElemento(2));
        assertEquals(false, b.buscaElemento(3));
    }

    @Test
    public void ordens() {
        BinarySearchTree b = new BinarySearchTree();
        b.insereElemento(7);
        b.insereElemento(4);
        b.insereElemento(1);
        b.insereElemento(6);
        b.insereElemento(10);
        b.insereElemento(8);
        b.insereElemento(12);
        assertArrayEquals(new int[]{1,4,6,7,8,10,12}, b.emOrdem());
        assertArrayEquals(new int[]{7,4,1,6,10,8,12}, b.preOrdem());
        assertArrayEquals(new int[]{1,6,4,8,12,10,7}, b.posOrdem());
    }

    @Test
    public void removerFilhoUnico() {
        BinarySearchTree b = new BinarySearchTree();
        b.insereElemento(1);
        b.insereElemento(2);
        b.insereElemento(3);
        b.remove(2);
        assertTrue(b.buscaElemento(1));
        assertTrue(b.buscaElemento(3));
        assertEquals(false, b.buscaElemento(2));
        assertEquals(false, b.buscaElemento(5));
    }

    @Test
    public void removerRaiz() {
        BinarySearchTree b = new BinarySearchTree();
        b.insereElemento(7);
        b.insereElemento(4);
        b.insereElemento(1);
        b.insereElemento(6);
        b.insereElemento(10);
        b.insereElemento(8);
        b.insereElemento(12);
        b.remove(7);
        assertTrue(b.buscaElemento(8));
        assertTrue(b.buscaElemento(12));
        assertEquals(false, b.buscaElemento(7));
        assertEquals(false, b.buscaElemento(30));
    }
}
