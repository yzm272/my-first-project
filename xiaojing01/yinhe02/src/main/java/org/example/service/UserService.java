package org.example.service;

import org.example.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> users = new HashMap<>();

    public UserService() {
        // Add some demo users
        users.put("a", new User("a", "1"));
        users.put("user", new User("user", "pass"));
    }

    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
