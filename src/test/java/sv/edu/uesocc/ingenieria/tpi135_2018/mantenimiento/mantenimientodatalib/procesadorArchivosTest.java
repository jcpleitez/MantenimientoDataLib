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
        System.out.println("*Prueba de cargarArchivo:");
        String path = getClass().getClassLoader().getResource("inventario.csv").getFile();
        procesadorArchivos instance = new procesadorArchivos();
        File expResult = new File(path);
        File result = instance.cargarArchivo(path);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Esto va a fallar");
    }

    
    /**
     * Test of separadorRegistros method, of class procesadorArchivos.
     */
    @Test
    public void testSeparadorRegistros() {
        System.out.println("*Prueba separadorLineas:");
        String path = getClass().getClassLoader().getResource("inventario.csv").getFile();
        File file = new File(path);
        procesadorArchivos instance = new procesadorArchivos();
        int expResult = 3; // Esperamos que haya 1 registro
        int result = instance.separadorRegistros(file).size(); // Cantidad de registros actuales        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of convertirObjectos method, of class procesadorArchivos.
     */
    @Test
    public void testConvertirObjectos() {
        System.out.println("*Prueba convertirObjectos:");
        ArrayList<String> todosRegistros = new ArrayList<String>();
        todosRegistros.add("1, HP1, 12040.3334. 080.0017, Lenovo, MJVZLKF, ThinkCentre M82 L, Licda. Rina de Zometa , Windows, \"7.0 Professional SP1, 64 bits\",true, \"Office 2010 Pirata, 8 GB RAM Bocinas y Mouse N° 12040.3334.080.0016\"");
        procesadorArchivos instance = new procesadorArchivos();
        int expResult = 1;
        int result = instance.convertirObjectos(todosRegistros).get(0).getIdMantenimiento();
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    

    
}
