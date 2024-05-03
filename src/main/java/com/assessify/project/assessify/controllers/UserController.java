package com.assessify.project.assessify.controllers;

import com.assessify.project.assessify.models.User;
import com.assessify.project.assessify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestParam("input") String input, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        User user;
        if (input.contains("@") && input.contains(".")) {
            user = userService.loginUser("email", input);
        } else {
            user = userService.loginUser("username", input);
        }

        if (user == null || !user.getPassword().equals(password)) {
            // Handle invalid login
            redirectAttributes.addFlashAttribute("error", "Invalid username/email or password");
            return "redirect:/login";
        }

        redirectAttributes.addFlashAttribute("message", "Login successful");
        redirectAttributes.addFlashAttribute("userID", user.getUserId().toString());
        return "redirect:/" + user.getUserId();
    }


    @PostMapping(value = "/register")
    public String register(@RequestParam String email, @RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        User user = userService.addUser(email, username, password);
        redirectAttributes.addFlashAttribute("message", "Successfully created user " + user.getUsername());
        return "redirect:/login";
    }

    @GetMapping(value = "/{userID}")
    public User getUser(@PathVariable String userID) {
        return userService.loginUser("id", userID);
    }
}
