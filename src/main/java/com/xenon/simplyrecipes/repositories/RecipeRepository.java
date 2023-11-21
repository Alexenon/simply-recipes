package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = """
            SELECT R.id, R.name, R.description, R.image_name, R.preparing_duration,
                R.date_created, C.recipe_id, C.name as 'category_name'
            FROM recipes R
            INNER JOIN categories C ON R.id = C.recipe_id
            WHERE C.name = :categoryName
            """, nativeQuery = true)
    List<Recipe> findByCategory(String categoryName);

}
