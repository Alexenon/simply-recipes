package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Long, User> {

    User findByUsername(String username);
}
