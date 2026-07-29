package com.sunil.smartticketbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.dto.LoginRequest;
import com.sunil.smartticketbooking.entity.User;
import com.sunil.smartticketbooking.repository.UserRepository;
import com.sunil.smartticketbooking.security.JwtUtill;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtill jwtUtil;

    public User registerUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public String loginUser(LoginRequest request) {

        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            return "User not found";
        }

        User user = userOptional.get();

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            // Generate JWT Token
            return jwtUtil.generateToken(user.getEmail());
        }

        return "Invalid Password";
    }
}