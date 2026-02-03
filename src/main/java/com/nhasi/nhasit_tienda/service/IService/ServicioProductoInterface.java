package com.nhasi.nhasit_tienda.service.IService;

import com.nhasi.nhasit_tienda.model.Filtros;
import com.nhasi.nhasit_tienda.model.Producto;
import java.util.List;

public interface ServicioProductoInterface {
    public String guardado(Producto produ);
    public List<Producto> listartodos();
    public List<Producto>Pormayorstock();
    public Producto encontrar(int id);
    public List<Producto> encontrarpornombre(String nombre);
    public void actualizar(String name, Producto produ);
    public void eliminar(int id);
    public List<Producto> filtroxs(Filtros filtrox);
}
