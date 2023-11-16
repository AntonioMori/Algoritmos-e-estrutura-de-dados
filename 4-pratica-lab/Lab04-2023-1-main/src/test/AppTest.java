package test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import list.EstruturaElementar;

public class AppTest {

    private EstruturaElementar e;

    @Before
    public void setUp() throws Exception {
        e = null;
    }

    @Test
    public void testInsereInicio() {
        assertEquals("Não é o primeiro " + 0, 1, 1);
    }

}
