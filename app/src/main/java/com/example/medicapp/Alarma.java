package com.example.medicapp;

import java.util.Calendar;

public class Alarma {
    String nombre;
    String sonido;
    Calendar hora_fecha;
    Doctor doctor;
    Medicamento medicamento;
    boolean vibrar;
    boolean activo;

    public Alarma(String nombre, Calendar hora_fecha, Doctor doctor) {
        this.nombre = nombre;
        this.hora_fecha = hora_fecha;
        this.doctor = doctor;
    }

    public Alarma(String nombre, Calendar hora_fecha, Medicamento medicamento) {
        this.nombre = nombre;
        this.hora_fecha = hora_fecha;
        this.medicamento = medicamento;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public boolean isVibrar() {
        return vibrar;
    }

    public void setVibrar(boolean vibrar) {
        this.vibrar = vibrar;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Alarma{" +
                "nombre='" + nombre + '\'' +
                ", hora_fecha=" + hora_fecha +
                '}';
    }
}
