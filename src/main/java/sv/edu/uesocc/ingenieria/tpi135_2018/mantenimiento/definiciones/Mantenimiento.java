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
public class Mantenimiento {
    
    
    private int idMantenimiento;
    private String historico;
    private String noInventario;
    private String marca;
    private String noSerie;
    private String modelo;
    private String responsable;
    private String sistemaOperativo;
    private String version;
    private boolean licencia;
    private String observaciones;

    public Mantenimiento() {
    }

    public Mantenimiento(int idMantenimiento, String historico, String noInventario, String marca, String noSerie, String modelo, String responsable, String sistemaOperativo, String version, boolean licencia, String observaciones) {
        this.idMantenimiento = idMantenimiento;
        this.historico = historico;
        this.noInventario = noInventario;
        this.marca = marca;
        this.noSerie = noSerie;
        this.modelo = modelo;
        this.responsable = responsable;
        this.sistemaOperativo = sistemaOperativo;
        this.version = version;
        this.licencia = licencia;
        this.observaciones = observaciones;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isLicencia() {
        return licencia;
    }

    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    
    
}
