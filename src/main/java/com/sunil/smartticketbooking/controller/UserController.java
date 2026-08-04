package com.sunil.smartticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sunil.smartticketbooking.dto.LoginRequest;
import com.sunil.smartticketbooking.dto.LoginResponse;
import com.sunil.smartticketbooking.entity.User;
import com.sunil.smartticketbooking.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        userService.registerUser(user);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        LoginResponse response = userService.loginUser(request);

        return ResponseEntity.ok(response);
    }
    
   
    @GetMapping("/count")
    public long getUserCount() {

        return userService.getUserCount();

    }
    
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();

    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User Deleted Successfully";

    }

}