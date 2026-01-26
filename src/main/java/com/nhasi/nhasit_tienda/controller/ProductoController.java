package com.nhasi.nhasit_tienda.controller;

import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.model.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nhasi.nhasit_tienda.service.servicioProductointerface;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tienda")
public class ProductoController {
    private final servicioProductointerface produ;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ProductoController(servicioProductointerface produ) {
        this.produ = produ;
    }

    @GetMapping("/porfavor")
    public String porfavor(){
        return "PENDEJO";
    }
    
    @GetMapping("/test-db")
    public String testDatabaseConnection() {
        try {
            String mensaje = jdbcTemplate.queryForObject(
                "SELECT nombre FROM producto WHERE id = 1", 
                String.class
            );
            return "✅ Conexión OK: " + mensaje;
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }
    @GetMapping("/save")
    public String save(@RequestBody Producto produx){
        return produ.guardado(produx);
    }
    @GetMapping("/All")
    public List<Producto> all(){
        return produ.listartodos();
    }
    @GetMapping("/Busquedafil/{categoria}")
    public List<DtoBusquedaCategoria> search(@PathVariable String categoria){
        return produ.listarcate(categoria);
    }
}
