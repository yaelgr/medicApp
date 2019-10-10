package com.example.medicapp;

public class AlarmaVo {
    private String nombre;
    private String hora;


    public AlarmaVo(String nombre, String hora) {
        this.nombre = nombre;
        this.hora = hora;
    }

    public String getNombreAlarma() {
        return nombre;
    }

    public void setNombreAlarma(String nombre) {
        this.nombre = nombre;
    }

    public String getHoraAlarma() {
        return hora;
    }

    public void setHoraAlarma(String info) {
        this.hora = hora;
    }
}
