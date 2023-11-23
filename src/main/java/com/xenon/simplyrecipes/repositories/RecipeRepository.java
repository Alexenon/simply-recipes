package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = """
            SELECT R.id, R.name, R.description, R.image_name, R.preparing_duration, R.cooking_duration, R.date_created,
                C.id as 'category_id', C.name as 'category_name', RC.recipe_id, RC.category_id
            FROM recipe_category RC
            INNER JOIN recipes R ON R.id = RC.recipe_id
            INNER JOIN categories C ON C.id = RC.category_id
            WHERE C.name = :categoryName
            """, nativeQuery = true)
    List<Recipe> findByCategory(String categoryName);

}
