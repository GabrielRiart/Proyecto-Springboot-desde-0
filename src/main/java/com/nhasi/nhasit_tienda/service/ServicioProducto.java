package com.nhasi.nhasit_tienda.service;

import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.model.Producto;
import com.nhasi.nhasit_tienda.repo.CategoriaRepo;
import com.nhasi.nhasit_tienda.repo.ProductoRepo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProducto implements ServicioProductoInterface {
    private ProductoRepo produRepo;
    public ServicioProducto(ProductoRepo produRepo){
        this.produRepo=produRepo;
    }

    @Override
    public String guardado(Producto produ){
            produRepo.save(produ);
            return "Ya se guardo crack";
    }
    @Override
    public List<Producto> listartodos(){
        return produRepo.findAll();
    }
    @Override
    public Producto encontrar(int id){
        return produRepo.findItem(id);
    }

}
