package com.example.medicapp.Class;

/**
 * @author Jaciel Israel Reséndiz Ochoa
 */

public class Doctor {
    String nombre;
    String telefono;
    String direccion;

    public Doctor(String nombre) {
        this.nombre = nombre;
    }

    public Doctor(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Doctor(String nombre, String direccion,char d) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Doctor(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}


