package com.sravan.Coding_Platform.controller;

import com.sravan.Coding_Platform.dto.RegisterRequest;
import com.sravan.Coding_Platform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request){
        userService.registerUser(request);
        return "User Registration Successful..";
    }
}
