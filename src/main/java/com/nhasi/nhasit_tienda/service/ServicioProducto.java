package com.nhasi.nhasit_tienda.service;

import com.nhasi.nhasit_tienda.model.Filtros;
import com.nhasi.nhasit_tienda.model.Producto;
import com.nhasi.nhasit_tienda.repo.ProductoRepo;

import com.nhasi.nhasit_tienda.service.IService.ServicioProductoInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioProducto implements ServicioProductoInterface {
    private ProductoRepo produRepo;
    public ServicioProducto(ProductoRepo produRepo){
        this.produRepo=produRepo;
    }
    @Override
    public void actualizar(String name ,Producto Produ){

        produRepo.updatedataP(name,Produ);
    }
    @Override
    public List<Producto> filtroxs(Filtros filtrox){
        return produRepo.findFiltered(filtrox);
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
    public List<Producto> encontrarpornombre(String name){return produRepo.findObject(name);}
    @Override
    public List<Producto> Pormayorstock() {
        return produRepo.findStock();
    }

    @Override
    public Producto encontrar(int id){
        return produRepo.findItem(id);
    }

    @Override
    public void eliminar(int id){
         produRepo.deleteProdu(id);
    }
}
