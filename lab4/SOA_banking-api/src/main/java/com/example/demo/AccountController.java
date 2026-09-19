package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final JwtUtil jwtUtil;

    public AccountController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/details")
    public ResponseEntity<String> getAccountDetails(
            @RequestHeader("Authorization") String authorization) {

        if (authorization == null ||
            !authorization.startsWith("Bearer ")) {

            return ResponseEntity
                    .status(401)
                    .body("Missing or invalid Authorization header");
        }

        String token = authorization.substring(7);

        if (!jwtUtil.validateToken(token)) {

            return ResponseEntity
                    .status(401)
                    .body("Invalid or expired token");
        }

        String username = jwtUtil.extractUsername(token);

        return ResponseEntity.ok(
                "Account Details for " + username +
                ": Balance = ₹50,000"
        );
    }
}