package com.ecommerce.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.demo.entities.User;
import com.ecommerce.demo.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/login", produces = { "application/json" })
@Tag(name = "ecommerce")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Cria uma novo usuário", method = "POST")
    @PostMapping("/create")
    public String createUser(@Valid @RequestBody String username, String password, Boolean isAdmin) {
        userService.createUser(new User(username, password, isAdmin));
        return "User criado com sucesso";
    }

}
