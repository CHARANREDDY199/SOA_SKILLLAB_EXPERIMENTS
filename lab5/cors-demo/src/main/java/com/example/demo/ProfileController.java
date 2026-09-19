package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProfileController {

    @GetMapping("/profile")
    public Profile getProfile() {
        return new Profile("Vaishu", "STU001", "vaishu@gmail.com");
    }

    static class Profile {
        private String name;
        private String id;
        private String email;

        public Profile(String name, String id, String email) {
            this.name = name;
            this.id = id;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }
    }
}
