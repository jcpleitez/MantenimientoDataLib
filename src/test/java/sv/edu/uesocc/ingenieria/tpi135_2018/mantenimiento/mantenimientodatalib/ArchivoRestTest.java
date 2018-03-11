/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author jcpleitez
 */
public class ArchivoRestTest {

    public ArchivoRestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of postLista method, of class ArchivoRest.
     */
    //@RunWith(PowerMockRunner.class)
    //@PrepareForTest(ClientBuilder.class)
    @Test
    public void testPostLista() {
        System.out.println("*Prueba postLista");

        List<List<String>> lista = new ArrayList<>();
        lista.add(new ArrayList<>());
        lista.get(0).add("1");
        lista.get(0).add("HP");
        lista.get(0).add("PC1");
        lista.add(new ArrayList<>());
        lista.get(1).add("2");
        lista.get(1).add("Samsung");
        lista.get(1).add("PC2");

        ArchivoRest instance = new ArchivoRest();
        URI expResult = null;
        URI result = instance.postLista(lista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
