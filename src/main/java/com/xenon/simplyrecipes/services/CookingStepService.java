package com.xenon.simplyrecipes.services;

import com.xenon.simplyrecipes.entities.CookingStep;
import com.xenon.simplyrecipes.repositories.CookingStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookingStepService {

    @Autowired
    private CookingStepRepository cookingStepRepository;

    public List<CookingStep> addCookingSteps(List<CookingStep> cookingSteps) {
        return cookingStepRepository.saveAll(cookingSteps);
    }

}
