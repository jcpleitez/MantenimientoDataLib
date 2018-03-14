/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dmmaga
 */
public class gestorArchivos {

    public String caracter;
    public boolean encabezado;
    private static String expresion = "(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    public gestorArchivos() {                                                   //Valores por defecto
        caracter = ",";
        encabezado = false;
    }

    public gestorArchivos(String caracter, boolean encabezado) {                //Valores personalizados
        this.caracter = caracter;
        this.encabezado = encabezado;
    }

    public boolean verificarArchivo(final String path) {
        if (path != null && !path.trim().isEmpty()) {                             //Verifica que no este vacio y nulo           
            File archivo = new File(path);
            return (archivo.isFile() && archivo.canRead());                     //Verifica las dos condiciones archivo y lectura
        }
        return false;
    }

    public boolean verificarDirectorio(final String path) {                      //Comprueba que exista y se pueda leer
        if (path != null && !path.trim().isEmpty()) {                             //Verifica que no este vacio y nulo
            File archivo = new File(path);
            return (archivo.isDirectory() && archivo.canRead());
        }
        return false;
    }

    public List<File> cargarArchivos(final String path) throws IOException {
        if (verificarDirectorio(path)) {                                          //Metodo incluye exepciones
            List<File> lista
                    = Files.walk(Paths.get(path)).
                            filter(a -> verificarArchivo(a.toString()) && a.getFileName().toString().endsWith(".csv")).
                            filter(Files::isRegularFile).
                            map(Path::toFile).
                            collect(Collectors.toList());
            return lista;
        }
        return null;
    }

    public List<List<String>> parser(File archivo) throws IOException {
        if (archivo != null) {
            List<List<String>> lista = new ArrayList<>();
            Files.lines(archivo.toPath()).
                    skip(this.encabezado ? 1 : 0).
                    filter(l -> l.contains(this.caracter)).
                    forEach((f) -> {
                        lista.add(Arrays.asList(f.split(this.caracter + this.expresion)));
                    });
            return lista;
        }
        return null;
    }

}
