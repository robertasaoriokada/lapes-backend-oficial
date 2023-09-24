package com.ecommerce.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.entities.User;
import com.ecommerce.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void createUser(User user) {
        userRepo.save(user);
    }
}
