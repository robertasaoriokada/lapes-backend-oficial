package com.ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.demo.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
