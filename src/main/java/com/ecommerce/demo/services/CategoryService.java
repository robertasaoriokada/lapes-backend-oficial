package com.ecommerce.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.entities.Category;
import com.ecommerce.demo.repository.CategoryRepo;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public void createCategory(Category category) {
        categoryRepo.save(category);
    }

    public Iterable<Category> listarCategory() {
        return categoryRepo.findAll();
    }

    public Optional<Category> listOneCategoryById(Integer id) {
        return this.categoryRepo.findById(id);
    }

    public void deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
    }

}
