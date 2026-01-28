package com.nhasi.nhasit_tienda.controller;

import com.nhasi.nhasit_tienda.model.Category;
import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.service.ServicioCategoriaInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/categoria")
public class CategoryController {
    private final ServicioCategoriaInterface categor;

    public CategoryController(ServicioCategoriaInterface categor) {
        this.categor = categor;
    }

    @GetMapping("/Busquedafil/{categoria}")
    public List<DtoBusquedaCategoria> search(@PathVariable String categoria){
        return categor.listarcate(categoria);
    }
    @GetMapping("/Categorias")
    public List<Category>all(){
        return categor.todascategorias();
    }
    @PostMapping("/agregar")
    public void insetInto(Category Catego){
        categor.agregar(Catego);
    }
    @PutMapping("/actualizar")
    public ResponseEntity<String> updateCategory(@RequestParam int id, @RequestBody Category category){
        try {
            categor.actualizar(id,category);
            return ResponseEntity.ok("Actualizado bro");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error id no valido"+ e);
        }
    }
}



