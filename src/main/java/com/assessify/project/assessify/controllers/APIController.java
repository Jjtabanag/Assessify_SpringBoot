package com.assessify.project.assessify.controllers;

import com.assessify.project.assessify.models.User;
import com.assessify.project.assessify.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "api/")
@RestController
public class APIController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome to the Assessify Backend API!";
    }


}
