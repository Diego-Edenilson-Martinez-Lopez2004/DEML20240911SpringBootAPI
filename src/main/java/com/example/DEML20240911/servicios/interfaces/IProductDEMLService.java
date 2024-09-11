package com.example.DEML20240911.servicios.interfaces;

import com.example.DEML20240911.dtos.productDEML.*;
import java.util.List;

public interface IProductDEMLService {

    List<SearchResultProductsDEML.ProductsDEML> obtenerTodos();
    GetIdResultProductDEML obtenerPorId(Integer id);
    GetIdResultProductDEML crear(CreateProductDEML createProductDEML);
    GetIdResultProductDEML editar(EditProductDEML editProductDEML);
    void eliminarPorId(Integer id);

}
