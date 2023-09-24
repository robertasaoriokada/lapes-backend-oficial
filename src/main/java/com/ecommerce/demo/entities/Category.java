package com.ecommerce.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer categoryId;

    @Column(name = "category_name")
    private @NotBlank String categoryName;

    @Column(name = "description")
    private @NotBlank String description;

    @Column(name = "imageURL")
    private @NotBlank String imageURL;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    Category() {
    }

    Category(@NotBlank String categoryName, @NotBlank String description, @NotBlank String imageURL) {
        this.categoryName = categoryName;
        this.description = description;
        this.imageURL = imageURL;
        this.products = new HashSet<>();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
