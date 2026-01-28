package com.nhasi.nhasit_tienda.service;

import com.nhasi.nhasit_tienda.model.Category;
import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.repo.CategoriaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioCategoria implements ServicioCategoriaInterface{
    private final CategoriaRepo categ;
    public ServicioCategoria(CategoriaRepo Catego){this.categ=Catego;}
    @Override
    public List<DtoBusquedaCategoria>listarcate(String category){
        return categ.findCategory(category);
    }
    @Override
    public List<Category>todascategorias(){
        return categ.findCategorys();
    }
    @Override
    public void agregar(Category catego){
         categ.insertar(catego);
    }
    @Override
    public void actualizar(int id,Category category){categ.updataCat(id,category);}

}
