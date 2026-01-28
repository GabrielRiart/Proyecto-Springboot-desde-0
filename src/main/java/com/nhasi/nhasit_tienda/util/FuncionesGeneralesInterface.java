package com.nhasi.nhasit_tienda.util;

import java.util.Comparator;
import java.util.List;

public interface FuncionesGeneralesInterface<T> {

    public List<T> ordenar(List<T> lista, Comparator<T> comparator);


}


