package com.ecommerce.demo.services;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String messageError) {
        super(messageError);
    }
}
