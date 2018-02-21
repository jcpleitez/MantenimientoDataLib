/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.Mantenimiento;

/**
 *
 * @author dmmaga
 */
public class procesadorArchivosTest {
    
    public procesadorArchivosTest() {
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
     * Test of cargarArchivo method, of class procesadorArchivos.
     */
    @org.junit.Test
    public void testCargarArchivo() {
        System.out.println("prueba de cargarArchivo");
        String path = getClass().getClassLoader().getResource("inventario.csv").getFile();
        procesadorArchivos instance = new procesadorArchivos();
        File expResult = new File(path);
        File result = instance.cargarArchivo(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Esto va a fallar");
    }

    /**
     * Test of cargarLista method, of class procesadorArchivos.
     */
    @Test
    public void testCargarLista() {
        System.out.println("prueba cargarLista");
        String path = getClass().getClassLoader().getResource("inventario.csv").getFile();
        File file = new File(path);
        procesadorArchivos instance = new procesadorArchivos();
        boolean expResult = true;
        boolean result = instance.cargarLista(file).get(0).isLicencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    
}
