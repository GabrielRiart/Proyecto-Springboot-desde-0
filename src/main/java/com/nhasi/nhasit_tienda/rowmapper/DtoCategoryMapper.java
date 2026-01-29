package com.nhasi.nhasit_tienda.rowmapper;

import com.nhasi.nhasit_tienda.model.DTO.DtoBusquedaCategoria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DtoCategoryMapper implements RowMapper<DtoBusquedaCategoria> {
    public DtoBusquedaCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        DtoBusquedaCategoria dto= new DtoBusquedaCategoria();
        dto.setNombreProducto(rs.getString("nombre"));
        dto.setPrecioProducto(rs.getInt("precio"));
        dto.setNombreCategoria(rs.getString("category_name"));
        return dto;
    }
}
