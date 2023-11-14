package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.RecipeCookingStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookingStepRepository extends JpaRepository<RecipeCookingStep, Long> {
}
