package com.nhasi.nhasit_tienda.controller;

import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.model.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import com.nhasi.nhasit_tienda.service.servicioProductointerface;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Producto produx){
        return ResponseEntity.status(HttpStatus.CREATED).body(produ.guardado(produx));
    }
    @GetMapping("/All")
    public List<Producto> all(){
        return produ.listartodos();
    }
    @GetMapping("/Busquedafil/{categoria}")
    public List<DtoBusquedaCategoria> search(@PathVariable String categoria){
        return produ.listarcate(categoria);
    }
    @GetMapping("/BusquedaId/{id}")
    public Producto searchIdcrack(@PathVariable int id){
        return produ.encontrar(id);
    }
}
