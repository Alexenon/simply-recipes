package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.CookingStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookingStepRepository extends JpaRepository<CookingStep, Long> {
}
