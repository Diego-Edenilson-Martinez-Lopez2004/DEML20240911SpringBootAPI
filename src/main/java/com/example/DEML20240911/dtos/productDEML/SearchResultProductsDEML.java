package com.example.DEML20240911.dtos.productDEML;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class SearchResultProductsDEML implements Serializable  {

    private int countRow;
    private List<ProductsDEML> data;

    @Getter
    @Setter
    public static class ProductsDEML implements Serializable {
        private int id;
        private String nombreDEML;
        private String descripcionDEML;
        private BigDecimal precio;
    }
}
