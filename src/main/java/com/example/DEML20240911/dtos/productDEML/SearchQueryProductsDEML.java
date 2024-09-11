package com.example.DEML20240911.dtos.productDEML;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter

public class SearchQueryProductsDEML implements Serializable {
    private String nombreDEML;
    private String descripcionDEML_Like;
    private int skip;
    private int take;
    private byte sendRowCount;
}
