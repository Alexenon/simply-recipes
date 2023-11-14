package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}