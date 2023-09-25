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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/category", produces = "application/json")
@Tag(name = "ecommerce")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Cria uma nova categoria", method = "POST")
    @PostMapping(path = "/create")
    public String createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return "Success";
    }

    @Operation(summary = "Lista todas as categorias existentes", method = "GET")
    @GetMapping(path = "/listAll")
    public Iterable<Category> listarCategory() {
        return categoryService.listarCategory();
    }

    @Operation(summary = "Lista uma categoria através do ID", method = "GET")
    @GetMapping(path = "/list")
    public Optional<Category> listOneCategoryById(@RequestParam(name = "id") Integer id) {
        return categoryService.listOneCategoryById(id);
    }

    @Operation(summary = "Exclui uma categoria do banco de dados através do ID", method = "DELETE")
    @DeleteMapping(path = "/delete")
    public String deletarCategoria(@RequestParam(name = "id") Integer id) {
        categoryService.deleteCategory(id);
        return "Success";
    }

}
