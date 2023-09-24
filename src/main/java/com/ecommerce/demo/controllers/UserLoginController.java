package com.ecommerce.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.demo.entities.User;
import com.ecommerce.demo.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String createUser(@Valid @RequestBody String username, String password, Boolean isAdmin) {
        userService.createUser(new User(username, password, isAdmin));
        return "User criado com sucesso";
    }

}
