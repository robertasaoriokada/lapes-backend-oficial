package com.ecommerce.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/product", produces = { "application/json" })
@Tag(name = "ecommerce")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Cria uma novo produto se a categoria passada como parâmeetro existir", method = "POST")
    @PostMapping("/create")
    public String createProduct(@Valid @RequestBody String nameProduct, String description, Double price,
            Integer idCategory,
            String urlProduct) {
        productService.createProduct(new Product(nameProduct, description, price,
                idCategory, urlProduct));
        return "Success";
    }

    @Operation(summary = "Lista todos os produtos existentes", method = "GET")
    @GetMapping(path = "/listAll")
    public Iterable<Product> listarProducts() {
        return productService.listProducts();
    }

    @Operation(summary = "Lista um produto através do ID", method = "GET")
    @GetMapping(path = "/list")
    public Optional<Product> listProductById(@RequestParam(name = "id") Integer id) {
        return productService.listProductById(id);
    }

    @Operation(summary = "Deleta um produto pelo ID", method = "DELETE")
    @DeleteMapping(path = "/delete")
    public String deleteProductByBy(@RequestParam(name = "id") Integer id) {
        productService.deleteProductById(id);
        return "Success";
    }
}
