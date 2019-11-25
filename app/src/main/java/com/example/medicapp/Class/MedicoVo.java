package com.example.medicapp.Class;

public class MedicoVo {
    private String nombre;
    private String domicilio;
    private String telefono;
    private String fecha;
    private String hora;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public MedicoVo(String nombre, String domicilio, String telefono, String fecha, String hora ) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.fecha = fecha;
        this.hora = hora;

    }


}
