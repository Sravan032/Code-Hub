package com.sravan.Coding_Platform.service;

import com.sravan.Coding_Platform.dto.LoginRequest;
import com.sravan.Coding_Platform.dto.RegisterRequest;
import com.sravan.Coding_Platform.model.User;
import com.sravan.Coding_Platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(RegisterRequest request){
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    public String loginUser(LoginRequest request){
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
        if(optionalUser.isEmpty()){
            return "User nor found!";
        }
        User user = optionalUser.get();

        boolean isPasswordMatch = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!isPasswordMatch){
            return "Incorrect Password.";
        }
        return "Login Successful";
    }
}


