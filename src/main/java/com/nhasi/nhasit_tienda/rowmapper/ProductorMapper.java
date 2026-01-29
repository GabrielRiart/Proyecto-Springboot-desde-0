package com.nhasi.nhasit_tienda.rowmapper;

import com.nhasi.nhasit_tienda.model.Producto;
import org.springframework.jdbc.core.RowMapper;

public class ProductorMapper implements RowMapper<Producto> {
    public Producto mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        Producto produ=new Producto();
        produ.setId(rs.getInt("id"));
        produ.setNombre(rs.getString("nombre"));
        produ.setPrecio(rs.getInt("precio"));
        produ.setStock(rs.getInt("stock"));
        produ.setCategory_id(rs.getInt("category_id"));
        return produ;
    }
}
