package com.nhasi.nhasit_tienda.repo;

import com.nhasi.nhasit_tienda.model.Category;
import com.nhasi.nhasit_tienda.model.DtoBusquedaCategoria;
import com.nhasi.nhasit_tienda.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

@Repository
public class ProductoRepo {
    private JdbcTemplate template;


    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    
    public void  save(Producto produ) {
        String sql="insert into producto (id,nombre,precio,stock,category_id) values (?,?,?,?,?)";
        template.update(sql,produ.getId(),produ.getNombre(),produ.getPrecio(),produ.getStock(),produ.getCategory_id());
    }
    public List<Producto> findAll(){
       String sql="select * from producto";
        /* RowMapper<Producto> rowMapper=new RowMapper<Producto>() {
            @Override
            public Producto mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Producto produ=new Producto();
                produ.setId(rs.getInt("id"));
                produ.setName(rs.getString("nombre"));
                produ.setPrecio(rs.getInt("precio"));
                produ.setStock(rs.getInt("stock"));
                return produ;
            }
        };
        List<Producto> productos = template.query(sql, rowMapper);
        */
        List<Producto> productos = template.query(sql,new BeanPropertyRowMapper<>(Producto.class));
        return productos;
    }
    public List<DtoBusquedaCategoria> findCategory(String categoria){
        String sql= "SELECT p.nombre, p.precio, c.category_name FROM producto AS p\n" +
                "INNER JOIN category AS c\n" +
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
}
