package com.example.movieapprestAPI.Controller;

import com.example.movieapprestAPI.Models.UserModel;
import com.example.movieapprestAPI.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
        try {
            UserModel newUser = userService.addUser(userModel);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (EmailAlreadyExistsExcept e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); // HttpStatus.CONFLICT indicates a duplicate entry
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginDTO userLoginDTO) {
        boolean isAuthenticated = userService.authenticateUser(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        if (isAuthenticated) {
            return new ResponseEntity<>("Authentication successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable String id) {
        Optional<UserModel> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email) {
        Optional<UserModel> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}