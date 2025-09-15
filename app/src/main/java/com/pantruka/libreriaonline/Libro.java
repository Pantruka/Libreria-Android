package com.pantruka.libreriaonline;

import java.io.Serializable;

public class Libro implements Serializable {
    private String codigo;
    private String nombre;
    private String descripcion;
    private String rutaIMG;

    public Libro(String codigo, String nombre, String descripcion, String rutaIMG) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaIMG = rutaIMG;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRutaIMG() {
        return rutaIMG;
    }
}