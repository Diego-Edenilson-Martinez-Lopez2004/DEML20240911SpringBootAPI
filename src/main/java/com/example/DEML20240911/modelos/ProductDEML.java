package com.example.DEML20240911.modelos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDEML {

    private int id;

    @NotNull(message = "El campo Nombre es obligatorio.")
    @Size(max = 100, message = "El campo Nombre no puede tener más de 100 caracteres.")
    private String nombreDEML;

    @Size(max = 255, message = "El campo Descripción no puede tener más de 255 caracteres.")
    private String descripcionDEML;

    @NotNull(message = "El campo Precio es obligatorio.")
    private BigDecimal precio;

    public ProductDEML() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDEML() {
        return nombreDEML;
    }

    public void setNombreDEML(String nombreDEML) {
        this.nombreDEML = nombreDEML;
    }

    public String getDescripcionDEML() {
        return descripcionDEML;
    }

    public void setDescripcionDEML(String descripcionDEML) {
        this.descripcionDEML = descripcionDEML;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

}