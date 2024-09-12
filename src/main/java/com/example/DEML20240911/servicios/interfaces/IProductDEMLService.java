package com.example.DEML20240911.servicios.interfaces;

import com.example.DEML20240911.dtos.productDEML.ProductDEMLGuardar;
import com.example.DEML20240911.dtos.productDEML.ProductDEMLEditar;
import com.example.DEML20240911.dtos.productDEML.ProductDEMLSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IProductDEMLService {
    
    List<ProductDEMLSalida> obtenerTodos();

    Page<ProductDEMLSalida> obtenerTodosPaginados(Pageable pageable);

    ProductDEMLSalida obtenerPorId(Integer id);

    ProductDEMLSalida crear(ProductDEMLGuardar createProductDEML);

    ProductDEMLSalida editar(Integer id, ProductDEMLEditar editProductDEML);
    
    void eliminarPorId(Integer id);

}
