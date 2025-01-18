package com.aida.controller;

import com.aida.model.User;
import com.aida.repository.UserRepository;
import com.aida.response.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(@RequestBody SignupRequest req){
        User user = new User();
        user.setEmail(req.getEmail());
        user.setFullName(req.getFullName());

        User savedUser = userRepository.save(user);

        return ResponseEntity.ok(savedUser);
    }
}




