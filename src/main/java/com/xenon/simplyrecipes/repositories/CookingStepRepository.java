package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.CookingStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookingStepRepository extends JpaRepository<CookingStep, Long> {
}
