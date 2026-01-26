package com.nhasi.nhasit_tienda.service;

import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.model.Producto;
import com.nhasi.nhasit_tienda.repo.ProductoRepo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicioProducto implements servicioProductointerface{
    private ProductoRepo produRepo;
    public servicioProducto(ProductoRepo produRepo){
        this.produRepo=produRepo;
    }
    @Override
    public List<DtoBusquedaCategoria>listarcate(String category){
        return produRepo.findCategory(category);
    }
    @Override
    public String guardado(Producto produ){
            produRepo.save(produ);
            return "Producto guardado exitosamente";
    }
    @Override
    public List<Producto> listartodos(){
        return produRepo.findAll();
    }
}
