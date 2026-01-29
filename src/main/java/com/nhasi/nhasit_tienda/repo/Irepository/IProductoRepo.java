package com.nhasi.nhasit_tienda.repo.Irepository;

import com.nhasi.nhasit_tienda.model.Producto;

import java.util.List;

public interface IProductoRepo {

    public void  save(Producto produ);
    public List<Producto> findAll();
    public Producto findItem(int id);
    public Producto findObject(String name);
    public void updatedataP(String noHOmbre, Producto produ);
    public List<Producto>findStock();
    public void delete(int idx);

    }
