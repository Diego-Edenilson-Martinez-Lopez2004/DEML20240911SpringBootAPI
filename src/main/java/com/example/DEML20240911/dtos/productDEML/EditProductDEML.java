package com.example.DEML20240911.dtos.productDEML;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class EditProductDEML implements Serializable {
    private Integer id;
    private String nombreDEML;
    private String descripcionDEML;
    private BigDecimal precio;

}
