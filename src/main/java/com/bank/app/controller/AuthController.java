package com.bank.app.controller;

import com.bank.app.dto.ResponseMessage;
import com.bank.app.model.User;
import com.bank.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> register(@RequestBody User user) {
        boolean success = userService.register(user);  // ✅ Pass whole object
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage("User registered successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessage("Username already exists."));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseMessage> login(@RequestBody User user) {
        boolean success = userService.login(user.getUsername(), user.getPassword());
        if (success) {
            return ResponseEntity.ok(new ResponseMessage("Login successful."));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Invalid credentials or rate-limited."));
        }
    }
}
