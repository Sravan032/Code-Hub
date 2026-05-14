package com.sravan.Coding_Platform.service;

import com.sravan.Coding_Platform.dto.RegisterRequest;
import com.sravan.Coding_Platform.model.User;
import com.sravan.Coding_Platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(RegisterRequest request){
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");
        return userRepository.save(user);
    }
}
