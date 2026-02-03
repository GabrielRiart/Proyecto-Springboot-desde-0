package com.nhasi.nhasit_tienda.repo.Irepository;

import com.nhasi.nhasit_tienda.model.Filtros;
import com.nhasi.nhasit_tienda.model.Producto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductoRepo {

    public void save(Producto produ);
    public List<Producto> findAll();
    public Producto findItem(int id);
    public List<Producto> findObject(String name);
    public void updatedataP(String noHOmbre, Producto produ);
    public List<Producto>findStock();
    public ResponseEntity<String> deleteProdu(int idx);
    public List<Producto> findFiltered(Filtros filtrx);

    }
