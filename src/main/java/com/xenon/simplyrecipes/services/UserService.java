package com.xenon.simplyrecipes.services;

import com.xenon.simplyrecipes.entities.User;
import com.xenon.simplyrecipes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getDefaultUser() {
        return getUserById(1L).orElseGet(() -> userRepository.findByUsername("test_user"));
    }

}
