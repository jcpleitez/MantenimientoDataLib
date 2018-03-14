/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.MigracionControl;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.MigracionHistorico;

/**
 *
 * @author dmmaga
 */
public class gestorArchivosTest {

    public gestorArchivosTest() {
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

    @Rule
    public TemporaryFolder carpetaPrueba = new TemporaryFolder();

    /**
     * Test of verificarArchivo method, of class gestorArchivos.
     */
    @Test
    public void testVerificarArchivo() throws IOException {
        System.out.println("*Prueba verificarArchivo");
        File tempFile1 = carpetaPrueba.newFile("file1.csv");
        String path = tempFile1.getPath();
        gestorArchivos instance = new gestorArchivos();
        boolean expResult = true;
        boolean result = instance.verificarArchivo(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of verificarDirectorio method, of class gestorArchivos.
     */
    @Test
    public void testVerificarDirectorio() {
        System.out.println("*Prueba verificarDirectorio");
        String path = carpetaPrueba.getRoot().getPath();
        gestorArchivos instance = new gestorArchivos();
        boolean expResult = true;
        boolean result = instance.verificarDirectorio(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cargarArchivos method, of class gestorArchivos.
     */
    @Test
    public void testCargarArchivos() throws Exception {
        System.out.println("*Prueba cargarArchivos");
        File tempFile1 = carpetaPrueba.newFile("file1.csv");
        File tempFile2 = carpetaPrueba.newFile("file2.txt");
        File tempFile3 = carpetaPrueba.newFile("file3.csv");
        File tempFile4 = carpetaPrueba.newFile("file4");
        File tempFolder1 = carpetaPrueba.newFolder("recursos");
        String path = carpetaPrueba.getRoot().getPath();
        gestorArchivos instance = new gestorArchivos();
        List<File> expResult = new ArrayList<>();
        expResult.add(tempFile3);expResult.add(tempFile1);//llenamos el arreglo
        List<File> expResultTwo = new ArrayList<>();
        expResultTwo.add(tempFile1);expResultTwo.add(tempFile3);//llenamos el arreglo
        List<File> result = instance.cargarArchivos(path);
        assertEquals(expResult.equals(result) || expResultTwo.equals(result), true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parser method, of class gestorArchivos.
     */
    @Test
    public void testParser() throws Exception {
        System.out.println("*Prueba parser");
        File archivo = carpetaPrueba.newFile("file1.csv");
        FileUtils.writeStringToFile(archivo, "1,dell,hd4k,ues\n2,hp,highHD,ues");
        gestorArchivos instance = new gestorArchivos();
        String expResult = "1";
        String result = instance.parser(archivo).get(0).get(0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parserControl method, of class gestorArchivos.
     */
    @Test
    public void testParserControl() {
        System.out.println("*prueba parserControl");
        List<List<String>> lista = new ArrayList<>();
        lista.add(new ArrayList<>());
        lista.get(0).add("Fisica");lista.get(0).add("1");lista.get(0).add("PC1");lista.get(0).add("0210-050996");lista.get(0).add("DELL");lista.get(0).add("PC72u1");lista.get(0).add("GTX");lista.get(0).add("Juan Carlos");lista.get(0).add("Linux");lista.get(0).add("14.5");lista.get(0).add("true");lista.get(0).add("Todo oc");
        lista.add(new ArrayList<>());
        lista.get(1).add("Matematicas");lista.get(1).add("2");lista.get(1).add("PC2");lista.get(1).add("0210-050567");lista.get(1).add("ASUS");lista.get(1).add("Puw7r1");lista.get(1).add("H61");lista.get(1).add("Diana Batres");lista.get(1).add("Windows");lista.get(1).add("8.1");lista.get(1).add("true");lista.get(1).add("Todo mal ah");
        gestorArchivos instance = new gestorArchivos();
        String expResult = "Fisica";
        List<MigracionControl> result = instance.parserControl(lista);
        assertEquals(expResult, result.get(0).getUnidad());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parserHistorico method, of class gestorArchivos.
     */
    @Test
    public void testParserHistorico() {
        System.out.println("*prueba parserHistorico");
        List<List<String>> lista = new ArrayList<>();
        lista.add(new ArrayList<>());
        lista.get(0).add("Juan Carlos");lista.get(0).add("0484.4857.263");lista.get(0).add("HP");lista.get(0).add("0210-050996");lista.get(0).add("Inspiron");lista.get(0).add("1");lista.get(0).add("26/04/16");lista.get(0).add("Preventivo");lista.get(0).add("Limpieza");lista.get(0).add("-");
        lista.add(new ArrayList<>());
        lista.get(1).add("Diana Batres");lista.get(1).add("0474.857.263");lista.get(1).add("ACER");lista.get(1).add("0210-54567");lista.get(1).add("Aspire");lista.get(1).add("2");lista.get(1).add("26/04/16");lista.get(1).add("Correctivo");lista.get(1).add("-");lista.get(1).add("Nueva licencia");
        gestorArchivos instance = new gestorArchivos();
        String expResult = "Diana Batres";
        List<MigracionHistorico> result = instance.parserHistorico(lista);
        assertEquals(expResult, result.get(1).getResponsableEquipo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
