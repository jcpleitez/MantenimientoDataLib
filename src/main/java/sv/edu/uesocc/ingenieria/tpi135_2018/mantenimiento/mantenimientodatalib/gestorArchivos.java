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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.MigracionControl;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.MigracionHistorico;

/**
 *
 * @author dmmaga
 */
public class gestorArchivos {

    private String caracter;
    private boolean encabezado;
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
        if (path != null && !path.trim().isEmpty()) {                           //Verifica que no este vacio y nulo           
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

    public List<MigracionControl> parserControl(List<List<String>> lista) {
        if (lista != null && !lista.isEmpty()) {
            List<MigracionControl> listaMC = new ArrayList<>();
            for (List<String> list : lista) {
                if (list.size() == 13 && !list.isEmpty()) {
                    MigracionControl registro = new MigracionControl();
                    registro.setUnidad(list.get(0));
                    registro.setIdControl(Integer.parseInt(list.get(1)));
                    registro.setHistoricoMtto(list.get(2));
                    registro.setNoInventario(list.get(3));
                    registro.setMarca(list.get(4));
                    registro.setNoSerie(list.get(5));
                    registro.setModelo(list.get(6));
                    registro.setResponsable(list.get(7));
                    registro.setSistemaOperativo(list.get(8));
                    registro.setVersion(list.get(9));
                    if(list.get(10).equals("X")){
                        registro.setLicencia(true);
                    }else if(list.get(11).equals("X")){
                        registro.setLicencia(false);
                    }                    
                    registro.setObservaciones(list.get(12));
                    listaMC.add(registro);
                }
            }
            return listaMC;
        }
        return null;
    }

    public List<MigracionHistorico> parserHistorico(List<List<String>> lista) {
        if (lista != null && !lista.isEmpty()) {
            List<MigracionHistorico> listaMH = new ArrayList<>();
            for (List<String> list : lista) {
                if (list.size() == 10 && !list.isEmpty()) {
                    MigracionHistorico registro = new MigracionHistorico();
                    registro.setResponsableEquipo(list.get(0));
                    registro.setNoInventario(list.get(1));
                    registro.setMarca(list.get(2));
                    registro.setNoSerie(list.get(3));
                    registro.setModelo(list.get(4));
                    registro.setIdHistorico(Integer.parseInt(list.get(5)));
                    registro.setFecha(list.get(6));
                    registro.setTipoMtto(list.get(7));
                    registro.setObservaciones(new String[]{list.get(8), list.get(9)});
                    listaMH.add(registro);
                }
            }
            return listaMH;
        }

        return null;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public boolean isEncabezado() {
        return encabezado;
    }

    public void setEncabezado(boolean encabezado) {
        this.encabezado = encabezado;
    }

}
