package com.example.DEML20240911.servicios.implementaciones;

import com.example.DEML20240911.dtos.productDEML.*;
import com.example.DEML20240911.modelos.ProductDEML;
import com.example.DEML20240911.repositorios.ProductDEMLIRepository;
import com.example.DEML20240911.servicios.interfaces.IProductDEMLService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDEMLService implements IProductDEMLService {

    @Autowired
    private ProductDEMLRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SearchResultProductsDEML.ProductsDEML> obtenerTodos() {
        List<ProductDEML> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, SearchResultProductsDEML.ProductsDEML.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetIdResultProductDEML obtenerPorId(Integer id) {
        ProductDEML product = productRepository.findById(id).orElseThrow();
        return modelMapper.map(product, GetIdResultProductDEML.class);
    }

    @Override
    public GetIdResultProductDEML crear(CreateProductDEML createProductDEML) {
        ProductDEML product = productRepository.save(modelMapper.map(createProductDEML, ProductDEML.class));
        return modelMapper.map(product, GetIdResultProductDEML.class);
    }

    @Override
    public GetIdResultProductDEML editar(EditProductDEML editProductDEML) {
        ProductDEML product = productRepository.save(modelMapper.map(editProductDEML, ProductDEML.class));
        return modelMapper.map(product, GetIdResultProductDEML.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productRepository.deleteById(id);
    }
}
