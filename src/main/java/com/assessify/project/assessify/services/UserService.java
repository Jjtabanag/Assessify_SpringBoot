package com.assessify.project.assessify.services;

import com.assessify.project.assessify.models.User;
import com.assessify.project.assessify.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(String email, String username, String password) {
        return userRepository.save(new User(email, username, password));
    }

    public User loginUser(String type, String input) {
        User u;
        if (type == "username") {
            u = userRepository.findByUsername(input);
        } else if (type == "email") {
            u = userRepository.findByEmail(input);
        } else {
            u = userRepository.findById(Long.valueOf(Long.parseLong(input))).orElse(null);
        }
        return u;
    }

    public User editEmail(int id, String email) {
        User u = userRepository.findById(Long.valueOf(id)).orElse(null);
        if (u != null) {
            u.setEmail(email);
            userRepository.save(u);
        }
        return u;
    }

    public User editUsername(int id, String username) {
        User u = userRepository.findById(Long.valueOf(id)).orElse(null);
        if (u != null) {
            u.setUsername(username);
            userRepository.save(u);
        }
        return u;
    }

    public User editPassword(int id, String password) {
        User u = userRepository.findById(Long.valueOf(id)).orElse(null);
        if (u != null) {
            u.setPassword(password);
            userRepository.save(u);
        }
        return u;
    }
}
