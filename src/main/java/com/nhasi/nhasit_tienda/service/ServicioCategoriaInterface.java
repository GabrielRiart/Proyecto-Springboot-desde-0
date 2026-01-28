package com.nhasi.nhasit_tienda.service;

import com.nhasi.nhasit_tienda.model.Category;
import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;

import java.util.List;

public interface ServicioCategoriaInterface {
    public List<DtoBusquedaCategoria> listarcate(String cate);
    public List<Category>todascategorias();
    public void agregar(Category categoria);
    public void actualizar(int id,Category category);
    public void deletear(int id);
}
