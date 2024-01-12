package com.xenon.simplyrecipes.services;

import com.xenon.simplyrecipes.entities.User;
import com.xenon.simplyrecipes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getDefaultUser() {
        return userRepository.findByUsername("test_user");
    }

}
