package com.nhasi.nhasit_tienda.service;

import com.nhasi.nhasit_tienda.model.Category;
import com.nhasi.nhasit_tienda.model.DTO.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.repo.CategoriaRepo;
import com.nhasi.nhasit_tienda.service.IService.ServicioCategoriaInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioCategoria implements ServicioCategoriaInterface {
    private final CategoriaRepo categrepo;
    public ServicioCategoria(CategoriaRepo Catego){this.categrepo =Catego;}
    @Override
    public List<DtoBusquedaCategoria>listarcate(String category){
        return categrepo.findCategory(category);
    }
    @Override
    public List<Category>todascategorias(){
        return categrepo.findCategorys();
    }
    @Override
    public void agregar(Category catego){
         categrepo.insertar(catego);
    }
    @Override
    public void actualizar(int id,Category category){
        categrepo.updataCat(id,category);}
    @Override
    public void deletear(int id){categrepo.eliminar(id);}
}
