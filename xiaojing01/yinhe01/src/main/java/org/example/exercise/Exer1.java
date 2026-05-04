package org.example.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exer1 {
    private static Map<String, String> users = new HashMap<>();

    static {
        // Demo users
        users.put("admin", "password123");
        users.put("user", "pass");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Login Demo");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Login successful! Welcome, " + username);
            // Simulate accessing protected resource
            System.out.println("You now have access to protected resources.");
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }

        scanner.close();
    }

    private static boolean authenticate(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}
