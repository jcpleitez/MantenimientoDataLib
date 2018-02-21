/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.Mantenimiento;

/**
 *
 * @author dmmaga
 */
public class procesadorArchivos {
    
    public ArrayList<Mantenimiento> cargarLista(File file){
        ArrayList<Mantenimiento> lista = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            String line;
            br = new BufferedReader(fr);
            lista = new ArrayList<Mantenimiento>();
            //Leer linea por linea
            while ((line = br.readLine()) != null){
                String lineArray[] = line.split(",");
                int idMantenimiento = Integer.parseInt(lineArray[0]);
                String historico = lineArray[1];
                String noInventario = lineArray[2];                
                String marca = lineArray[3];
                String noSerie = lineArray[4];
                String modelo = lineArray[5];
                String responsable = lineArray[6];
                String sistemaOperativo = lineArray[7];
                String version = lineArray[8];
                boolean licencia = lineArray[9].equals(" true");
                String observaciones = lineArray[10];
                Mantenimiento registro = new Mantenimiento(idMantenimiento, historico, noInventario, marca, noSerie, modelo, responsable, sistemaOperativo, version, licencia, observaciones);
                lista.add(registro);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return lista;        
    }
    
    public File cargarArchivo(final String path){
        if (path!=null && !path.trim().isEmpty()) { //Vrifica que no este vacio y nulo           
            File archivo = new File (path);              
            if(archivo.isFile()){                   //Verifica que sea un archivo
                return archivo;
            }
        }
        return null;
    }
    
    
    
    
    
    
    
}