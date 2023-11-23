USE RecipeBookDB;

INSERT INTO Categories (name) VALUES
    ('Breakfast'),
    ('Lunch'),
    ('Dinner');

-- Inserting new recipes
INSERT INTO Recipes (name, description, image_name, preparing_duration, cooking_duration, date_created)
VALUES
    ('Salad Caesar', 'Salad with Caesar dressing', 'salad-caesar.jpg', 20, 50, CURDATE()),
    ('Pasta Carbonara', 'Classic Italian pasta dish with eggs, cheese, and pancetta', 'pasta-carbonara.jpg', 15, 20, CURDATE()),
    ('Grilled Salmon', 'Delicious grilled salmon with a lemon and herb marinade', 'grilled-salmon.jpg', 10, 15, CURDATE()),
    ('Beef Tacos', 'Delicious and flavorful beef tacos with fresh salsa and guacamole', 'beef-tacos.jpg', 20, 30, CURDATE()),
    ('Mushroom Risotto', 'Creamy and savory mushroom risotto with Arborio rice and Parmesan cheese', 'mushroom-risotto.jpg', 25, 35, CURDATE()),
    ('Chicken Alfredo', 'Creamy pasta dish with grilled chicken and Parmesan cheese', 'chicken-alfredo.jpg', 20, 30, CURDATE());

-- Inserting ingredients for the new recipes
INSERT INTO Ingredients (name, amount, recipe_id)
VALUES
    ('Tomatoes', 3, 1),
    ('Lettuce', 1, 1),
    ('Slices of bread', 5, 1),
    ('Eggs', 2, 1),
    ('Spaghetti', 200, 2),
    ('Eggs', 2, 2),
    ('Pancetta', 100, 2),
    ('Parmesan cheese', 50, 2),
    ('Black pepper', 'to taste', 2),
    ('Salmon fillets', 4, 3),
    ('Lemon', 1, 3),
    ('Fresh herbs', 'to taste', 3),
    ('Beef sirloin, diced', 500, 4),
    ('Taco seasoning', '2 tbsp', 4),
    ('Tomatoes, diced', 2, 4),
    ('Onion, chopped', 1, 4),
    ('Lettuce, shredded', '1 cup', 4),
    ('Tortillas', 8, 4),
    ('Mushrooms, sliced', 300, 5),
    ('Arborio rice', 1, 5),
    ('Vegetable broth', '4 cups', 5),
    ('White wine', '1/2 cup', 5),
    ('Onion, finely chopped', 1, 5),
    ('Garlic, minced', '3 cloves', 5),
    ('Parmesan cheese', '1/2 cup', 5),
    ('Chicken breast', 2, 6),
    ('Heavy cream', '1 cup', 6),
    ('Butter', '2 tbsp', 6),
    ('Garlic, minced', '3 cloves', 6),
    ('Parmesan cheese', '1 cup', 6);

-- Inserting cooking steps for the new recipes
INSERT INTO cooking_steps (step, recipe_id)
VALUES
    ('Tear the chunks of romaine lettuce', 1),
    ('Cook the meat', 2),
    ('Cook the vegetables', 2),
    ('Tear the chunks of romaine lettuce', 2),
    ('Combine and serve', 2),
    ('Cook the salmon fillets on the grill', 3),
    ('Season the salmon with the lemon and herbs', 3),
    ('Grill until cooked through', 3),
    ('Season the diced beef with taco seasoning', 4),
    ('Cook the beef in a skillet over medium heat until browned', 4),
    ('In a bowl, mix diced tomatoes and chopped onion to make salsa', 4),
    ('Warm the tortillas and assemble the beef tacos with lettuce, salsa, and guacamole', 4),
    ('In a large pan, sauté the finely chopped onion and minced garlic in olive oil', 5),
    ('Add the sliced mushrooms and cook until softened', 5),
    ('Stir in the Arborio rice and cook for 2 minutes', 5),
    ('Pour in the white wine and cook until absorbed', 5),
    ('Gradually add the vegetable broth, stirring constantly until the rice is creamy and tender', 5),
    ('Stir in the grated Parmesan cheese and season with salt and pepper', 5),
    ('Grill the chicken breast until cooked through', 6),
    ('Slice the grilled chicken and set aside', 6),
    ('In a pan, melt butter and sauté garlic until fragrant', 6),
    ('Pour in the heavy cream and simmer until slightly thickened', 6),
    ('Stir in the Parmesan cheese until melted and the sauce is smooth', 6),
    ('Toss the cooked pasta in the sauce until well coated', 6);

-- Associating the new recipes with categories
INSERT INTO recipe_category(recipe_id, category_id)
VALUES
    (1, 1),  -- Salad Caesar is categorized as Breakfast
    (1, 2),  -- Salad Caesar is categorized as Lunch
    (2, 3),  -- Pasta Carbonara is categorized as Dinner
    (3, 3),  -- Grilled Salmon is categorized as Dinner
    (4, 4),  -- Beef Tacos is categorized as Dinner
    (5, 4),  -- Mushroom Risotto is categorized as Dinner
    (6, 3);  -- Chicken Alfredo is categorized as Dinner



