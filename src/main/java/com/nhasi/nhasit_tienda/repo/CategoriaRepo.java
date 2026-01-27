package com.nhasi.nhasit_tienda.repo;

import com.nhasi.nhasit_tienda.model.Category;
import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CategoriaRepo {
    private JdbcTemplate template;
    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<DtoBusquedaCategoria> findCategory(String categoria){
        String sql= "SELECT p.nombre, p.precio, c.category_name FROM producto AS p\n" +
                "INNER JOIN Category AS c\n" +
                "ON p.category_id=c.category_id WHERE category_name=? \n" ;
        RowMapper<DtoBusquedaCategoria> rowMapper =new RowMapper<DtoBusquedaCategoria>() {
            @Override
            public DtoBusquedaCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
                DtoBusquedaCategoria dto= new DtoBusquedaCategoria();
                dto.setNombreProducto(rs.getString("nombre"));
                dto.setPrecioProducto(rs.getInt("precio"));
                dto.setNombreCategoria(rs.getString("category_name"));
                return dto;
            }
        };
        List<DtoBusquedaCategoria> productos = template.query(sql,rowMapper,categoria);
        return productos;
    }
    public List<Category>findCategorys(){
        String sql ="Select * from category";
        RowMapper<Category> rowMapper = new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
                Category catego = new Category();
                catego.setCategory_id(rs.getInt("category_id"));
                catego.setCategory_name(rs.getString("category_name"));
                return catego;
            }

         };
        List<Category> categorias = template.query(sql,rowMapper);


        /*List<Category> categorias = template.query(sql,new BeanPropertyRowMapper<>(Category.class));*/
        return categorias;
    }
    public void insertar(Category Categoria){
        String sql= "INSERT INTO category (category_name) values (?)";
        template.update(sql,Categoria.getCategory_name());

    }
}
