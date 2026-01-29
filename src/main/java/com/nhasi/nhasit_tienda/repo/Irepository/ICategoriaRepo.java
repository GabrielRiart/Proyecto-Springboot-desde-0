package com.nhasi.nhasit_tienda.repo.Irepository;

import com.nhasi.nhasit_tienda.model.Category;
import com.nhasi.nhasit_tienda.model.DTO.DtoBusquedaCategoria;

import java.util.List;

public interface ICategoriaRepo {
    public List<DtoBusquedaCategoria> findCategory(String categoria);
    public List<Category>findCategorys();
    public void insertar(Category Categoria);
    public void updataCat(int id,Category category);
    public void eliminar(int idx);

    }
