package com.nhasi.nhasit_tienda.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {
    @NotNull
    @JsonProperty("categoria_id")
    private int category_id;
    @NotBlank
    @JsonProperty("categoria_name")
    private String category_name;

}
