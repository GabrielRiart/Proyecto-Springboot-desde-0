package com.nhasi.nhasit_tienda.controller;


import com.nhasi.nhasit_tienda.model.Filtros;
import com.nhasi.nhasit_tienda.model.Producto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import com.nhasi.nhasit_tienda.service.IService.ServicioProductoInterface;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/tienda")
public class ProductoController {
    private final ServicioProductoInterface produ;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ProductoController(ServicioProductoInterface produ) {
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
    public ResponseEntity<String> save(@Valid @RequestBody Producto produx){
        return ResponseEntity.status(HttpStatus.CREATED).body(produ.guardado(produx));


    }
    @GetMapping("/All")
    public List<Producto> all(){
        return produ.listartodos();
    }

    @GetMapping("/BusquedaId/{id}")
    public Producto searchIdcrack(@PathVariable int id){
        return produ.encontrar(id);
    }
    @GetMapping("/BusquedaNombre/{nombre}")
    public List<Producto> searchnamebro(@PathVariable @NotBlank String nombre){
        return produ.encontrarpornombre(nombre);
    }
    @GetMapping("/filtros")
    public List<Producto> searchfilters(@ModelAttribute Filtros filtrox){
        return produ.filtroxs(filtrox);
    }
    @GetMapping("/MayorStonks")
    public List<Producto> MayorStock(){
        return produ.Pormayorstock();
    }
    @PutMapping("/actualizar")
    public ResponseEntity<String> updateProducto(@RequestParam String name,@RequestBody Producto produx){
        try{
            produ.actualizar(name,produx);
            return ResponseEntity.ok("Se actualizo el producto  ");

        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error" + error.getMessage());
        }
    }
    @DeleteMapping("/deletear/{ID}")
    public void deletear(@Valid @PathVariable int ID){

        produ.eliminar(ID);

    }
}
