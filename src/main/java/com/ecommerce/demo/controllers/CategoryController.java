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

import com.ecommerce.demo.entities.Category;
import com.ecommerce.demo.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/create")
    public String createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return "Success";
    }

    @GetMapping(path = "/listAll")
    public Iterable<Category> listarCategory() {
        return categoryService.listarCategory();
    }

    @GetMapping(path = "/list")
    public Optional<Category> listOneCategoryById(@RequestParam(name = "id") Integer id) {
        return categoryService.listOneCategoryById(id);
    }

    @DeleteMapping(path = "/delete")
    public String deletarCategoria(@RequestParam(name = "id") Integer id) {
        categoryService.deleteCategory(id);
        return "Success";
    }

}
