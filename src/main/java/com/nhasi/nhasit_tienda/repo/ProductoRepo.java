package com.nhasi.nhasit_tienda.repo;

import com.nhasi.nhasit_tienda.model.Filtros;
import com.nhasi.nhasit_tienda.model.Producto;
import com.nhasi.nhasit_tienda.repo.Irepository.IProductoRepo;
import com.nhasi.nhasit_tienda.rowmapper.ProductorMapper;
import com.nhasi.nhasit_tienda.util.FuncionesGenerales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class ProductoRepo implements IProductoRepo {
    private final ProductorMapper rowProduc = new ProductorMapper();
    private JdbcTemplate template;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private FuncionesGenerales<Producto> funcionesGenerales;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void save(Producto produ) {
        String sql="insert into producto (id,nombre,precio,stock,category_id) values (?,?,?,?,?)";
        template.update(sql,produ.getId(),produ.getNombre(),produ.getPrecio(),produ.getStock(),produ.getCategory_Id());

    }
    @Override
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

        /*List<Producto> productos = template.query(sql,new BeanPropertyRowMapper<>(Producto.class));*/
        List<Producto> productos = template.query(sql,rowProduc);
        return productos;
    }

    @Override
    public Producto findItem(int id){
        String sql= "SELECT * FROM producto AS p\n"  +
                " WHERE id= ? \n" ;
        return template.queryForObject(sql,rowProduc,id);
    }
    @Override
    public List<Producto> findObject(String name){
        String sql = "SELECT * FROM producto AS p " +
                "WHERE 1=1";
        MapSqlParameterSource params = new MapSqlParameterSource();
        if (!name.isEmpty()){
            sql+=" AND p.nombre ILIKE :nombre";
            params.addValue("nombre","%"+name+"%");
        }
        List<Producto> listaproduct=  namedParameterJdbcTemplate.query(sql,params,rowProduc);
        return listaproduct;

        /*
        String sql= "SELECT * FROM producto AS p\n"  +
                " WHERE nombre= ? \n" ;
        return template.queryForObject(sql,rowProduc,name);*/
    }
    @Override
    public void updatedataP(String noHOmbre, Producto produ){
        String sql= "UPDATE public.producto\n" +
                "\tSET  precio=?, stock=?, category_id=?\n" +
                "\tWHERE nombre = ?;";

        template.update(sql,produ.getPrecio(),produ.getStock(),produ.getCategory_Id(),noHOmbre);
    }
    @Override
    public List<Producto>findStock(){
        String sql ="Select p.nombre, p.precio,p.stock from producto AS p";
        RowMapper<Producto> rowMapper= new RowMapper<Producto>() {
            @Override
            public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Producto pro = new Producto();
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getInt("precio"));
                pro.setStock(rs.getInt("stock"));
                return pro;
            }
        };
        List<Producto> stonks= template.query(sql,rowMapper);
        List<Producto> finalstock= funcionesGenerales.ordenar(stonks,Comparator.comparing(Producto::getStock).reversed());
        return finalstock;
    }
    @Override
    public ResponseEntity<String> deleteProdu(int idx){
        String sql="DELETE FROM producto WHERE id=?";
        template.update(sql,idx);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino le contenido");
    }
    @Override
    public List<Producto> findFiltered(Filtros filtrox){
        String sql="SELECT * FROM producto AS p " +
                " WHERE 1=1";
        MapSqlParameterSource params = new MapSqlParameterSource();
        if (filtrox.getPreciomin()>0 && filtrox.getPreciomax()>0){
            sql+=" AND p.precio>= :preciomin AND p.precio <= :preciomax";
            params.addValue("preciomin",filtrox.getPreciomin());
            params.addValue("preciomax",filtrox.getPreciomax());

        }
        if (!filtrox.getNombre_producto().isEmpty()){
            sql+=" AND p.nombre ILIKE :nombre";
            params.addValue("nombre","%"+filtrox.getNombre_producto()+"%");
        }
        List<Producto> listafinal= namedParameterJdbcTemplate.query(sql,params,rowProduc);

        return listafinal;
    }
}
