package com.nhasi.nhasit_tienda.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "")
    private String nombre_producto;

    private int id_category;
}
