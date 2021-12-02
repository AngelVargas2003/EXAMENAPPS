package com.example.examenfinalapps.Modelos;

public class accion {
    private String Accion;
    private String descripcion;
    private int id;

    public String getAccion() {
        return Accion;
    }

    public void setAccion(String accion) {
        this.Accion=accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public accion(String accion,String descripcion,int id) {
        this.Accion=accion;
        this.descripcion=descripcion;
        this.id=id;
    }
}
