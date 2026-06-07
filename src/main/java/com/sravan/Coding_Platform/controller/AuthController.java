package com.sravan.Coding_Platform.controller;

import com.sravan.Coding_Platform.dto.LoginRequest;
import com.sravan.Coding_Platform.dto.RegisterRequest;
import com.sravan.Coding_Platform.model.User;
import com.sravan.Coding_Platform.service.RateLimitService;
import com.sravan.Coding_Platform.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private RateLimitService rateLimitService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request){
        userService.registerUser(request);
        return "User Registration Successful..";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request, HttpServletRequest httpServletRequest){
        String ipAdd = httpServletRequest.getRemoteAddr();
        if(!rateLimitService.isAllowed(ipAdd)){
            throw new RuntimeException("Too many login requests. Please try again after sometime.");
        }
        return userService.loginUser(request);
    }
}

