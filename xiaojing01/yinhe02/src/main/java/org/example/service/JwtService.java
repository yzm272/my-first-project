package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String generateToken(Object user) {
        // In real app, use JWT library
        return "demo-token-" + System.currentTimeMillis();
    }
}
