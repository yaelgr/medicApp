package com.example.medicapp.Class;

public class ConfigVo {
    private String titulo;
    private String desc;
    private int imagen;

    public ConfigVo(String titulo, String desc, int imageid) {
        this.titulo = titulo;
        this.desc = desc;
        this.imagen = imageid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }



}
