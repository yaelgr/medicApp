package com.example.medicapp.Class;

public class MedicamentoVo {

    private String nombre;
    private String nombreAlt;
    private String fechaInicial;
    private String fechaFinal;
    private String frecuencia;


    public MedicamentoVo(String nombre, String nombreAlt, String fechaInicial, String fechaFinal, String frecuencia) {
        this.nombre = nombre;
        this.nombreAlt = nombreAlt;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaInicial;
        this.frecuencia = frecuencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAlt() {
        return nombreAlt;
    }

    public void setNombreAlt(String nombreAlt) {
        this.nombreAlt = nombreAlt;
    }


    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

}
