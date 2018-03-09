/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.Mantenimiento;

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
     * Test of getMantenimiento method, of class ArchivoRest.
     */
    

    @Test
    public void testGetMantenimiento() {
        System.out.println("*Prueba getMantenimiento");
        String uri = "";
        ArchivoRest instance = new ArchivoRest();
        Mantenimiento expResult = null;
        Mantenimiento result = instance.getMantenimiento(uri);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
