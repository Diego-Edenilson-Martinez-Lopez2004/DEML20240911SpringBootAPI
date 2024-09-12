package com.example.DEML20240911.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "productDEML")
public class ProductDEML {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreDEML;

   
    private String descripcionDEML;

   
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