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
// import com.ecommerce.demo.services.CategoryNotFoundException;
// import com.ecommerce.demo.services.CategoryService;
import com.ecommerce.demo.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    // @Autowired
    // private CategoryService categoryService;

    @PostMapping("/create")
    public String createProduct(@Valid @RequestBody String nameProduct, String description, Double price,
            Integer idCategory,
            String urlProduct) {
        // if (categoryService.listOneCategoryById(idCategory) != null) {
        productService.createProduct(new Product(nameProduct, description, price,
                idCategory, urlProduct));
        return "Success";
        // } else {
        // throw new CategoryNotFoundException("A categoria associada ao produto não
        // existe");
        // }
    }

    @GetMapping(path = "/listAll")
    public Iterable<Product> listarProducts() {
        return productService.listProducts();
    }

    @GetMapping(path = "/list")
    public Optional<Product> listProductById(@RequestParam(name = "id") Integer id) {
        return productService.listProductById(id);
    }

    @DeleteMapping(path = "/delete")
    public String deleteProductByBy(@RequestParam(name = "id") Integer id) {
        productService.deleteProductById(id);
        return "Success";
    }
}
