package com.nhasi.nhasit_tienda.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Producto {

    @PositiveOrZero(message = "Debe ingresar un id")
    private int id;
    @NotBlank(message = "No texto vacio")
    @JsonProperty("nombre")
    private String nombre;
    @NotNull
    @JsonProperty("precio")
    private int precio ;
    @NotNull
    @JsonProperty("stock")
    int Stock;
    @NotNull
    @JsonProperty("categoria_id")
    private int category_Id;
}
