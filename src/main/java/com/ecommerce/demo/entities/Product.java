package com.ecommerce.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer productId;

    @Column(name = "productName")
    private @NotBlank String productName;

    @Column(name = "price")
    private @Min(0) Double price;

    @Column(name = "productDescription")
    private @NotBlank String productDescription;

    @Column(name = "productURL")
    private @NotBlank String productURL;

    @ManyToMany
    @JoinColumn(name = "cartList")
    private Set<Cart> carts;

    @Column(name = "idCategory")
    private @NotNull Integer idCategory;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private @NotBlank Category category;

    Product() {
    }

    public Product(@NotBlank String productName, @NotBlank String productDescription, @NotBlank Double price,
            @NotBlank Integer idCategory,
            @NotBlank String productURL) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.idCategory = idCategory;
        this.price = price;
        this.productURL = productURL;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Cart> getCart() {
        return carts;
    }

    public void setCart(Set<Cart> cart) {
        this.carts = cart;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

}