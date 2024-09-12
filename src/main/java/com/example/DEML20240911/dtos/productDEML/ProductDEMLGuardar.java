package com.example.DEML20240911.dtos.productDEML;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;


import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class ProductDEMLGuardar implements Serializable {

    @NotBlank(message = "El nombre es obligatorio")
    @JsonProperty("Nombre")
    private String nombreDEML;

    @JsonProperty("Descripción")
    private String descripcionDEML;

    @NotNull(message = "El precio es obligatorio")
    @JsonProperty("Precio")
    private BigDecimal precio;
}
