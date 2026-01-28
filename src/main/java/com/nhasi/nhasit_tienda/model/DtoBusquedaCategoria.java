package com.nhasi.nhasit_tienda.model;

public class DtoBusquedaCategoria {
    private String NombreProducto;
    private int precioProducto;
    private String NombreCategoria;


    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        NombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "DtoBusquedaCategoria{" +
                "NombreProducto='" + NombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", NombreCategoria='" + NombreCategoria + '\'' +
                '}';
    }
}
