package test;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import analiz.Analizador;

public class AppTest {

    @Test
    public void analizador() {
        Analizador lst = new Analizador();
        double[] probs = {0.8};
        int[] valores = {10};
        int[] resposta = lst.acha_sequencia(probs, valores);
        int[] esperado = {0};
        assertArrayEquals(esperado, resposta);

        double[] probs2 = {0.8, 0.4};
        int[] valores2 = {10, 5};
        int[] resposta2 = lst.acha_sequencia(probs2, valores2);
        int[] esperado2 = {0, 1};
        assertArrayEquals(esperado2, resposta2);

        double[] probs3 = {0.5, 0.9, 0.2, 0.6};
        int[] valores3 = {3, 1, 4, 1};
        int[] resposta3 = lst.acha_sequencia(probs3, valores3);
        int[] esperado3 = {1, 0, 3, 2};
        assertArrayEquals(esperado3, resposta3);
    }

}
