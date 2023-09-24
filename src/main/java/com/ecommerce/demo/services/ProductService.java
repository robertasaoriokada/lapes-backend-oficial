package com.ecommerce.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryService categoryService;

    public void createProduct(Product product) {
        if (categoryService.listOneCategoryById(product.getIdCategory()) != null) {
            productRepo.save(product);
        } else {
            throw new CategoryNotFoundException("A categoria associada ao produto não existe");
        }
    }

    public Iterable<Product> listProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> listProductById(Integer id) {
        return productRepo.findById(id);
    }

    public void deleteProductById(Integer id) {
        productRepo.deleteById(id);
    }
}
