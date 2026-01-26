package com.nhasi.nhasit_tienda.service;

import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.model.Producto;
import java.util.List;

public interface servicioProductointerface {
    public String guardado(Producto produ);
    public List<Producto> listartodos();
    public List<DtoBusquedaCategoria> listarcate(String cate);

}
