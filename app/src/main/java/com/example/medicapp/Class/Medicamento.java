package com.example.medicapp.Class;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
// import java.util.Date;

/**
 * @author Jaciel Israel Reséndiz Ochoa
 */
public class Medicamento {
    private String nombre;

    public Medicamento(String data) {
        this.nombre=data;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

