package org.example.controller;

import org.example.model.LoginRequest;
import org.example.model.LoginResponse;
import org.example.model.User;
import org.example.service.JwtService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // 验证用户凭据
        User user = userService.authenticate(request.getUsername(), request.getPassword());

        if (user != null) {
            // 生成JWT令牌
            String token = jwtService.generateToken(user);
            return ResponseEntity.ok(new LoginResponse("Login successful", token));
        } else {
            return ResponseEntity.status(401).body(new LoginResponse("Invalid credentials"));
        }
    }

    @GetMapping("/protected")
    public ResponseEntity<?> protectedEndpoint(@RequestHeader(value = "Authorization", required = false) String token) {
        if (token != null && token.startsWith("demo-token-")) {
            return ResponseEntity.ok("Access granted! Welcome to protected resource.");
        } else {
            return ResponseEntity.status(403).body("Access denied. Please login first.");
        }
    }
}
