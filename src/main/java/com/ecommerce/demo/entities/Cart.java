package com.ecommerce.demo.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(name = "cartProducts", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private Set<Product> cartProducts;

    @Column(name = "isEfectuated")
    private @NotBlank Boolean isEffectuated;

    @OneToOne
    private @NotBlank Payment payment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    Cart() {
        this.isEffectuated = false;
    }

}