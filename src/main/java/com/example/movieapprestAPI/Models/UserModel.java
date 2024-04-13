package com.example.movieapprestAPI.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserModel {
    @Id
    private String id; // MongoDB generates this ID.
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmpassword;


    // Default constructor
    public UserModel() {
    }

    // Parameterized constructor
    public UserModel(String firstName, String lastName, String email, String password, String confirmpassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    // IMPORTANT: Consider using a password encoder in the setter
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmpassword;
    }
    public void setConfirmPassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
