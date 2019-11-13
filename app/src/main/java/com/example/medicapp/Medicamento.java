package com.example.medicapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
// import java.util.Date;

/**
 * @author Jaciel Israel Reséndiz Ochoa
 */
public class Medicamento {
   String nombre;

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
