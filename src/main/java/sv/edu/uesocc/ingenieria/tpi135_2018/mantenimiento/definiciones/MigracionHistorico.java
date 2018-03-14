/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones;

/**
 *
 * @author dmmaga
 */
public class MigracionHistorico {
    
    private String responsableEquipo;
    private String noInventario;
    private String marca;
    private String noSerie;
    private String modelo;
    private int idHistorico;
    private String fecha;
    private String tipoMtto;
    private String observaciones[];

    public MigracionHistorico() {
    }

    public MigracionHistorico(String responsableEquipo, String noInventario, String marca, String noSerie, String modelo, int idiHistorico, String fecha, String tipoMtto, String[] observaciones) {
        this.responsableEquipo = responsableEquipo;
        this.noInventario = noInventario;
        this.marca = marca;
        this.noSerie = noSerie;
        this.modelo = modelo;
        this.idHistorico = idiHistorico;
        this.fecha = fecha;
        this.tipoMtto = tipoMtto;
        this.observaciones = observaciones;
    }

    public String getResponsableEquipo() {
        return responsableEquipo;
    }

    public void setResponsableEquipo(String responsableEquipo) {
        this.responsableEquipo = responsableEquipo;
    }

    public String getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(String noInventario) {
        this.noInventario = noInventario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoMtto() {
        return tipoMtto;
    }

    public void setTipoMtto(String tipoMtto) {
        this.tipoMtto = tipoMtto;
    }

    public String[] getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String[] observaciones) {
        this.observaciones = observaciones;
    }
    
}
