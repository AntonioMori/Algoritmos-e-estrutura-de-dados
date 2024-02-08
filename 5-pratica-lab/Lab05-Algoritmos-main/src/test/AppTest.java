package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import ordenadores.Ordenador;
import ordenadores.OrdenarPorInsercao;
import ordenadores.OrdenarPorMerge;
import ordenadores.OrdenarPorSelecao;

public class AppTest {

    private OrdenarPorInsercao i;
    private OrdenarPorSelecao s;
    private OrdenarPorMerge m;

    @Before
    public void setUp() throws Exception {
        i = new OrdenarPorInsercao();
        s = new OrdenarPorSelecao();
        m = new OrdenarPorMerge();
    }

    @Test
    public void testSelecao() {
        //PRECISIONA IMPLEMENTAR NA AULA
        Ordenador o = s;
        int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
        int[] arrayOrdenado = { 0, 1, 2, 3, 4, 5, 6, 7 };
        assertTrue(Arrays.equals(arrayOrdenado, o.ordene(array)));
        int[] array2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] arrayOrdenado2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        assertTrue(Arrays.equals(arrayOrdenado2, o.ordene(array2)));
        int[] array3 = { 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] arrayOrdenado3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        assertTrue(Arrays.equals(arrayOrdenado3, o.ordene(array3)));
        int[] array4 = { 0 };
        int[] arrayOrdenado4 = { 0 };
        assertTrue(Arrays.equals(arrayOrdenado4, o.ordene(array4)));
        int[] array5 = { 5, 3, 2, 4, 7, 2, 0, 7 };
        int[] arrayOrdenado5 = { 0, 2, 2, 3, 4, 5, 7, 7 };
        assertTrue(Arrays.equals(arrayOrdenado5, o.ordene(array5)));
    }

    @Test
    public void testInsertion() {
        //PRECISIONA IMPLEMENTAR NA AULA
        Ordenador o = i;
        int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
        int[] arrayOrdenado = { 0, 1, 2, 3, 4, 5, 6, 7 };
        assertTrue(Arrays.equals(arrayOrdenado, o.ordene(array)));
        int[] array2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] arrayOrdenado2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        assertTrue(Arrays.equals(arrayOrdenado2, o.ordene(array2)));
        int[] array3 = { 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] arrayOrdenado3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        assertTrue(Arrays.equals(arrayOrdenado3, o.ordene(array3)));
        int[] array4 = { 0 };
        int[] arrayOrdenado4 = { 0 };
        assertTrue(Arrays.equals(arrayOrdenado4, o.ordene(array4)));
        int[] array5 = { 5, 3, 2, 4, 7, 2, 0, 7 };
        int[] arrayOrdenado5 = { 0, 2, 2, 3, 4, 5, 7, 7 };
        assertTrue(Arrays.equals(arrayOrdenado5, o.ordene(array5)));
    }

    @Test
    public void testMergeSort() {
        //NÃO PRECISIONA IMPLEMENTAR NA AULA
        Ordenador o = m;
        int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
        int[] arrayOrdenado = { 0, 1, 2, 3, 4, 5, 6, 7 };
        assertTrue(Arrays.equals(arrayOrdenado, o.ordene(array)));
        int[] array2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] arrayOrdenado2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        assertTrue(Arrays.equals(arrayOrdenado2, o.ordene(array2)));
        int[] array3 = { 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] arrayOrdenado3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        assertTrue(Arrays.equals(arrayOrdenado3, o.ordene(array3)));
        int[] array4 = { 0 };
        int[] arrayOrdenado4 = { 0 };
        assertTrue(Arrays.equals(arrayOrdenado4, o.ordene(array4)));
        int[] array5 = { 5, 3, 2, 4, 7, 2, 0, 7 };
        int[] arrayOrdenado5 = { 0, 2, 2, 3, 4, 5, 7, 7 };
        assertTrue(Arrays.equals(arrayOrdenado5, o.ordene(array5)));
    }

    @Test
    public void testMerge() {
        //PRECISIONA IMPLEMENTAR NA AULA
        int[] array = {  7, 9, 15, 17, 20};
        int[] array2 = { 0, 1,  2, 22, 30};
        int[] r = { 0, 1,  2, 7, 9,15, 17,20, 22, 30};
        assertTrue(Arrays.equals(r, m.merge(array, array2)));
        assertTrue(Arrays.equals(r, m.merge(array2, array)));
        int[] array3 = { 1, 2, 3, 4, 5};
        int[] array4 = { 6, 7, 8, 9, 10};
        int[] r2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertTrue(Arrays.equals(r2, m.merge(array3, array4)));
    }

}
