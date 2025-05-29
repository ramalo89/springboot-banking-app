package com.bank.app.service;

import com.bank.app.model.User;
import com.bank.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean register(User user) {
        if (repo.existsByUsername(user.getUsername())) {
            return false;
        }
        repo.save(user);
        return true;
    }

    // ✅ Return boolean instead of string
    public boolean login(String username, String password) {
        User user = repo.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
