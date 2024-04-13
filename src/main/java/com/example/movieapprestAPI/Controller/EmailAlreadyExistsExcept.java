package com.example.movieapprestAPI.Controller;

public class EmailAlreadyExistsExcept extends RuntimeException{

    public EmailAlreadyExistsExcept(String email) {
        super("A user with the email " + email + " already exists.");
    }

}
