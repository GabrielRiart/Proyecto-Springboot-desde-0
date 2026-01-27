package com.nhasi.nhasit_tienda.service;

import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.model.Producto;
import java.util.List;

public interface ServicioProductoInterface {
    public String guardado(Producto produ);
    public List<Producto> listartodos();

    public Producto encontrar(int id);

}
