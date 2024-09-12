package com.example.DEML20240911.controladores;

import com.example.DEML20240911.dtos.productDEML.ProductDEMLGuardar;
import com.example.DEML20240911.dtos.productDEML.ProductDEMLEditar;
import com.example.DEML20240911.dtos.productDEML.ProductDEMLSalida;
import com.example.DEML20240911.servicios.interfaces.IProductDEMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductDEMLController {
    @Autowired
    private IProductDEMLService productDEMLService;

    @GetMapping
    public ResponseEntity<Page<ProductDEMLSalida>> mostrarTodosPaginados(Pageable pageable) {
        Page<ProductDEMLSalida> productsDEML = productDEMLService.obtenerTodosPaginados(pageable);
        if (productsDEML.hasContent()) {
            return ResponseEntity.ok(productsDEML);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductDEMLSalida>> mostrarTodos() {
        List<ProductDEMLSalida> productsDEML = productDEMLService.obtenerTodos();
        if (!productsDEML.isEmpty()) {
            return ResponseEntity.ok(productsDEML);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDEMLSalida> buscarPorId(@PathVariable Integer id) {
        ProductDEMLSalida productDEML = productDEMLService.obtenerPorId(id);

        if (productDEML != null) {
            return ResponseEntity.ok(productDEML);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductDEMLSalida> crear(@RequestBody ProductDEMLGuardar createProductDEML) {
        ProductDEMLSalida productDEML = productDEMLService.crear(createProductDEML);
        return ResponseEntity.ok(productDEML);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDEMLSalida> editar(@PathVariable Integer id, @RequestBody ProductDEMLEditar editProductDEML){
        ProductDEMLSalida productDEML = productDEMLService.editar(id, editProductDEML);
        return ResponseEntity.ok(productDEML);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        productDEMLService.eliminarPorId(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}