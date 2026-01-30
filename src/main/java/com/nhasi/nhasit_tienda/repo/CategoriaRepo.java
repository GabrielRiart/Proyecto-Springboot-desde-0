package com.nhasi.nhasit_tienda.repo;

import com.nhasi.nhasit_tienda.model.Category;
import com.nhasi.nhasit_tienda.model.DTO.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.repo.Irepository.ICategoriaRepo;
import com.nhasi.nhasit_tienda.rowmapper.CategoryMapper;
import com.nhasi.nhasit_tienda.rowmapper.DtoCategoryMapper;
import com.nhasi.nhasit_tienda.util.FuncionesGeneralesInterface;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
@Repository
public class CategoriaRepo implements ICategoriaRepo {
    private JdbcTemplate template;
    private final CategoryMapper rowCategory= new CategoryMapper();
    private final DtoCategoryMapper rowCategoryDto = new DtoCategoryMapper();
    @Autowired
    private FuncionesGeneralesInterface funcional;
    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<DtoBusquedaCategoria> findCategory(@Valid @NotBlank String categoria){

        String sql= "SELECT p.nombre, p.precio, c.category_name FROM producto AS p\n" +
                "INNER JOIN Category AS c\n" +
                "ON p.category_id=c.category_id WHERE category_name=? \n" ;
        List<DtoBusquedaCategoria> productos = template.query(sql,rowCategoryDto,categoria);
        return productos;
    }
    @Override
    public List<Category>findCategorys(){
        String sql ="Select * from category";
        List<Category> categorias = template.query(sql,rowCategory);
        List<Category> categoriasf = funcional.ordenar(categorias, Comparator.comparing(Category::getCategory_id));


            /*List<Category> categorias = template.query(sql,new BeanPropertyRowMapper<>(Category.class));*/
        return categoriasf;
    }
    @Override
    public void insertar(Category Categoria){
        String sql= "INSERT INTO category (category_name) values (?)";
        template.update(sql,Categoria.getCategory_name());

    }
    @Override
    public void updataCat(int id,Category category){
        String sql= "UPDATE category SET category_name=? WHERE category_id=?";
        template.update(sql,category.getCategory_name(),id);
    }
    @Override
    public void eliminar(int idx){
        String sql= "DELETE FROM category WHERE category_id =?";
        template.update(sql,idx);
    }

}
