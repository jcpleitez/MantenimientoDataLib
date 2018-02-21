/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.io.File;
import java.io.FileReader;

/**
 *
 * @author dmmaga
 */
public class procesadorArchivos {
    
    
    
    public boolean cargarArchivo(final String path){
        if (path!=null && !path.trim().isEmpty()) {
            try {
                File archivo = new File (path);
                FileReader fr = new FileReader (archivo);
                return true;
            } catch (Exception e) {
          
            }

        }
            return false;
    }
    
    
    
    
    
}