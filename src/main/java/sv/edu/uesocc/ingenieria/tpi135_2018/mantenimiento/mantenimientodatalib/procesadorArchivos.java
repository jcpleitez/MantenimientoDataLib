/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.Mantenimiento;

/**
 *
 * @author dmmaga
 */
public class procesadorArchivos {
    
    public File validarArchivo(final String path){
        if (path!=null && !path.trim().isEmpty()) { //Verifica que no este vacio y nulo           
            File archivo = new File (path);              
            if(archivo.isFile() && archivo.canRead()){//Verifica que sea un archivo y que tenga permisos de leer
                return archivo;
            }
        }
        return null;
    }
    
    public boolean validarDirectorio(final String path){
        if (path!=null && !path.trim().isEmpty()) { //Verifica que no este vacio y nulo
            File archivo = new File (path);              
            return (archivo.isDirectory() && archivo.canRead());
        }
        return false;
    }
    
    public File[] cargarArchivos(final String path) throws IOException{        
        Object[] lista = Files.walk(Paths.get(path)).
                filter(a -> !validarDirectorio(a.toString()) & a.getFileName().toString().endsWith(".csv")).                
                toArray();
        File[] archivos = new File[lista.length];
        for (int i = 0; i < lista.length; i++) {
            archivos[i]= new File(lista[i].toString());
        }

        return archivos;
    }
    
    
    public ArrayList<String> separadorRegistros(File file){
        ArrayList<String> lista = null;
        FileReader fr;
        BufferedReader br;
        if (file != null) {
            try {
                String line;
                fr = new FileReader(file);            
                br = new BufferedReader(fr);
                lista = new ArrayList<String>();
                //Agregar linea por linea
                while ((line = br.readLine()) != null){                
                    lista.add(line);
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }            
        }else{
            System.out.println("File is null");
        }        
        return lista;
    }
    
    public ArrayList<Mantenimiento> convertirObjectos(ArrayList<String> todosRegistros){
        ArrayList<Mantenimiento> lista = null;
        if (todosRegistros != null && todosRegistros.size() > 0) {
            lista = new ArrayList<Mantenimiento>();
            for (String registro : todosRegistros) {
                String lineArray[] = registro.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                Mantenimiento mn = convertirMantenimiento(lineArray);
                lista.add(mn);
            }
        }else{
            System.out.println("Todos los registros Null o ningun registro");
        }        
        return lista;
    }
    
    public Mantenimiento convertirMantenimiento(String arreglo[]){
        Mantenimiento mantenimiento = null;
        if(arreglo.length == 11){ // 11 son las variables privadas de nuestra clase mantenimiento
            mantenimiento = new Mantenimiento();
            mantenimiento.setIdMantenimiento(Integer.parseInt(arreglo[0]));
            mantenimiento.setHistorico(arreglo[1]);
            mantenimiento.setNoInventario(arreglo[2]);
            mantenimiento.setMarca(arreglo[3]);
            mantenimiento.setNoSerie(arreglo[4]);
            mantenimiento.setModelo(arreglo[5]);
            mantenimiento.setResponsable(arreglo[6]);
            mantenimiento.setSistemaOperativo(arreglo[7]);
            mantenimiento.setVersion(arreglo[8]);
            mantenimiento.setLicencia(arreglo[9].equals("true"));
            mantenimiento.setObservaciones(arreglo[10]);
        }
        return mantenimiento;        
    }
    
    
    
    
}