package com.example.materialapp.entidades;

public class materiales {
    public Integer id_mat;
    public String nombre_mat;
    public double precio_mat;


    public materiales(Integer id_mat,String nombre_mat, double precio_mat) {
        this.id_mat = id_mat;
        this.nombre_mat = nombre_mat;
        this.precio_mat = precio_mat;
    }

    public Integer getId_mat() {
        return id_mat;
    }


    public void setId_mat(Integer id_mat) {
        this.id_mat = id_mat;
    }

    public String getNombre_mat() {
        return nombre_mat;
    }

    public void setNombre_mat(String nombre_mat) {
        this.nombre_mat = nombre_mat;
    }

    public double getPrecio_mat() {
        return precio_mat;
    }

    public void setPrecio_mat(double precio_mat) {
        this.precio_mat = precio_mat;
    }
}
