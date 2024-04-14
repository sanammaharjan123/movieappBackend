package com.example.movieapprestAPI.Controller;

public class EmailAlreadyExistsExcept extends RuntimeException{

    public EmailAlreadyExistsExcept(String email) {
        super("This email " + email + " already exists.");
    }

}
