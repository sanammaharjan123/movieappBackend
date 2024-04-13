package com.example.movieapprestAPI.Services;


import com.example.movieapprestAPI.Models.UserModel;
import com.example.movieapprestAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public Optional<UserModel> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public Optional<UserModel> getUserById(String id) {
        return userRepository.findById(id);
    }

    public UserModel addUser(UserModel user) {
        // Corrected method call to findByEmail
        Optional<UserModel> existingUser = findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists with email: " + user.getEmail());
        }
        // Encrypting the password here before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean authenticateUser(String email, String password) {
        Optional<UserModel> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            UserModel user = userOpt.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}