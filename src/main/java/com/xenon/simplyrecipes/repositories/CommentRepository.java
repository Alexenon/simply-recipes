package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
