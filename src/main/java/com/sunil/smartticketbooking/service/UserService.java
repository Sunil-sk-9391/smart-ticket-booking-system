package com.sunil.smartticketbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunil.smartticketbooking.dto.LoginRequest;
import com.sunil.smartticketbooking.dto.LoginResponse;
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

    public LoginResponse loginUser(LoginRequest request) {

        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        // Generate JWT Token
        String token = jwtUtil.generateToken(user.getEmail());

        // Return LoginResponse DTO
        return new LoginResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getRole(),
                token
        );
    }
    public List<User> getAllUsers() {

        return userRepository.findAll();

    }
    
    public long getUserCount() {

        return userRepository.count();

    }
    
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }
}