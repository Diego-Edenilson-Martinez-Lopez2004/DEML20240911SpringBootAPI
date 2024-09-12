package com.example.DEML20240911.servicios.implementaciones;
import com.example.DEML20240911.dtos.productDEML.ProductDEMLGuardar;
import com.example.DEML20240911.dtos.productDEML.ProductDEMLEditar;
import com.example.DEML20240911.dtos.productDEML.ProductDEMLSalida;
import com.example.DEML20240911.modelos.ProductDEML;
import com.example.DEML20240911.repositorios.IProductDEMLRepository;
import com.example.DEML20240911.servicios.interfaces.IProductDEMLService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDEMLService implements IProductDEMLService {

    @Autowired
    private IProductDEMLRepository productDEMLRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDEMLSalida> obtenerTodos() {
        List<ProductDEML> productsDEML = productDEMLRepository.findAll();

        return productsDEML.stream()
                .map(productDEML -> modelMapper.map(productDEML, ProductDEMLSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductDEMLSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<ProductDEML> page = productDEMLRepository.findAll(pageable);

        List<ProductDEMLSalida> productDEMLDto = page.stream()
                .map(productDEML -> modelMapper.map(productDEML, ProductDEMLSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(productDEMLDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public ProductDEMLSalida obtenerPorId(Integer id) {
        return modelMapper.map(productDEMLRepository.findById(id).orElse(null), ProductDEMLSalida.class);
    }

    @Override
    public ProductDEMLSalida crear(ProductDEMLGuardar createProductDEML) {
        ProductDEML productDEML = productDEMLRepository.save(modelMapper.map(createProductDEML, ProductDEML.class));
        return modelMapper.map(productDEML, ProductDEMLSalida.class);
    }

    @Override
    public ProductDEMLSalida editar(Integer id, ProductDEMLEditar editProductDEML) {
        ProductDEML existingProduct = productDEMLRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        modelMapper.map(editProductDEML, existingProduct);
        ProductDEML updatedProduct = productDEMLRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, ProductDEMLSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productDEMLRepository.deleteById(id);
    }
}