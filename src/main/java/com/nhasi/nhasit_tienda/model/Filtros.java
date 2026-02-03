package com.nhasi.nhasit_tienda.model;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Filtros {
    @PositiveOrZero
    private int preciomin;
    @PositiveOrZero
    private int preciomax;
    private String nombre_producto;
    private int id_category;
}
