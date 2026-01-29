package com.nhasi.nhasit_tienda.rowmapper;

import com.nhasi.nhasit_tienda.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category catego = new Category();
        catego.setCategory_id(rs.getInt("category_id"));
        catego.setCategory_name(rs.getString("category_name"));
        return catego;
    }
}
