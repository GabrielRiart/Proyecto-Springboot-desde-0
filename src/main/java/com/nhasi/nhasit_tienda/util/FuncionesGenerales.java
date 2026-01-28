package com.nhasi.nhasit_tienda.util;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Comparator;
@Component
public class FuncionesGenerales<T> implements FuncionesGeneralesInterface<T> {
    @Override
    public List<T> ordenar(List<T> lista, Comparator<T> comparator) {
        lista.sort(comparator);
        return lista;
    }
}
