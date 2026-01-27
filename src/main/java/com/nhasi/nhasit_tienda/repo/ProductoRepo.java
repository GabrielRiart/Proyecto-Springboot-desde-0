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
import org.springframework.web.bind.annotation.GetMapping;

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


    public Producto findItem(int id){
        String sql= "SELECT * FROM producto AS p\n"  +
                " WHERE id= ? \n" ;
        RowMapper<Producto> rowMapper=new RowMapper<Producto>() {
            @Override
            public Producto mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Producto produ=new Producto();
                produ.setId(rs.getInt("id"));
                produ.setNombre(rs.getString("nombre"));
                produ.setPrecio(rs.getInt("precio"));
                produ.setStock(rs.getInt("stock"));
                produ.setCategory_id(rs.getInt("category_id"));
                return produ;
             }

         };
        return template.queryForObject(sql,rowMapper,id);
    }
}
