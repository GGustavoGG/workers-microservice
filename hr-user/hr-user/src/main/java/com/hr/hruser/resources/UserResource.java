package com.hr.hruser.resources;

import com.hr.hruser.entities.User;
import com.hr.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(Objects.requireNonNull(userRepository.findById(id).orElse(null)));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findById(@RequestParam String email) {
        return ResponseEntity.ok(Objects.requireNonNull(userRepository.findByEmail(email)));
    }
}
