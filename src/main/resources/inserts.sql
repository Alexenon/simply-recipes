USE RecipeBookDB;

INSERT INTO Categories (name) VALUES
    ('Breakfast'),
    ('Lunch'),
    ('Dinner'),
    ('Appetizers'),
    ('Desserts'),
    ('Healthy Choices');

-- Inserting new recipes
INSERT INTO Recipes (id, name, description, image_name, preparing_duration, cooking_duration, date_created)
VALUES
    (1, 'Salad Caesar', 'Salad with Caesar dressing', 'salad-caesar.jpg', 20, 50, CURDATE()),
    (2, 'Pasta Carbonara', 'Classic Italian pasta dish with eggs, cheese, and pancetta', 'pasta-carbonara.jpg', 15, 20, CURDATE()),
    (3, 'Grilled Salmon', 'Delicious grilled salmon with a lemon and herb marinade', 'grilled-salmon.jpg', 10, 15, CURDATE()),
    (4, 'Beef Tacos', 'Delicious and flavorful beef tacos with fresh salsa and guacamole', 'beef-tacos.jpg', 20, 30, CURDATE()),
    (5, 'Mushroom Risotto', 'Creamy and savory mushroom risotto with Arborio rice and Parmesan cheese', 'mushroom-risotto.jpg', 25, 35, CURDATE()),
    (6, 'Chicken Alfredo', 'Creamy pasta dish with grilled chicken and Parmesan cheese', 'chicken-alfredo.jpg', 20, 30, CURDATE());
    (7, 'French Toast', 'Classic breakfast dish made with bread soaked in eggs and milk, then fried', 'french-toast.jpg', 10, 15, CURDATE()),
    (8, 'Chicken Stir-Fry', 'Quick and flavorful stir-fry with chicken, vegetables, and a savory sauce', 'chicken-stir-fry.jpg', 15, 20, CURDATE()),
    (9, 'Vegetable Curry', 'Hearty and aromatic curry with a variety of vegetables and spices', 'vegetable-curry.jpg', 20, 30, CURDATE()),
    (10, 'Beef Stroganoff', 'Comforting beef dish cooked with onions, mushrooms, and sour cream, served over noodles', 'beef-stroganoff.jpg', 20, 25, CURDATE()),
    (11, 'Lemon Garlic Shrimp', 'Tender shrimp cooked in a zesty lemon and garlic sauce, perfect for a quick and light dinner', 'lemon-garlic-shrimp.jpg', 10, 15, CURDATE());

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
    ('Parmesan cheese', '1 cup', 6),
    ('Bread slices', 4, 7),
    ('Eggs', 3, 7),
    ('Milk', 0.5, 7),
    ('Chicken breast, sliced', 500, 8),
    ('Bell peppers, sliced', 2, 8),
    ('Broccoli florets', 1, 8),
    ('Soy sauce', 2, 8),
    ('Vegetable oil', 2, 8),
    ('Mixed vegetables (carrots, potatoes, peas, etc.)', 2, 9),
    ('Coconut milk', 1, 9),
    ('Curry powder', 1, 9),
    ('Beef sirloin, thinly sliced', 600, 10),
    ('Onion, sliced', 1, 10),
    ('Mushrooms, sliced', 200, 10),
    ('Sour cream', 0.5, 10),
    ('Egg noodles', 8, 10),
    ('Shrimp, peeled and deveined', 500, 11),
    ('Garlic, minced', 4, 11),
    ('Lemon juice', 2, 11),
    ('Butter', 3, 11);

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
    ('Toss the cooked pasta in the sauce until well coated', 6),
    ('Soak the bread slices in the egg and milk mixture', 7),
    ('Fry the soaked bread slices until golden brown', 7),
    ('Stir-fry the chicken slices in hot oil until cooked through', 8),
    ('Add the vegetables and soy sauce, stir-fry until tender-crisp', 8),
    ('Combine and serve with rice', 8),
    ('Sauté the mixed vegetables in oil until slightly softened', 9),
    ('Stir in the curry powder and cook for a minute', 9),
    ('Pour in the coconut milk and simmer until the vegetables are tender', 9),
    ('Serve hot with rice or bread', 9),
    ('Cook the beef slices in a hot pan until browned', 10),
    ('Add the onion and mushrooms, cook until softened', 10),
    ('Stir in the sour cream and heat through, season with salt and pepper', 10),
    ('Cook the egg noodles according to package instructions', 10),
    ('Serve the beef stroganoff over the cooked noodles', 10),
    ('Melt butter in a skillet over medium heat', 11),
    ('Add the minced garlic and cook until fragrant', 11),
    ('Add the shrimp and cook until pink and opaque', 11),
    ('Stir in the lemon juice and cook for another minute', 11);

-- Associating the new recipes with categories
INSERT INTO recipe_category(recipe_id, category_id)
VALUES
    (1, 1),  -- Salad Caesar is categorized as Breakfast
    (1, 2),  -- Salad Caesar is categorized as Lunch
    (2, 3),  -- Pasta Carbonara is categorized as Dinner
    (3, 3),  -- Grilled Salmon is categorized as Dinner
    (4, 4),  -- Beef Tacos is categorized as Dinner
    (5, 4),  -- Mushroom Risotto is categorized as Dinner
    (6, 3),  -- Chicken Alfredo is categorized as Dinner
    (7, 1),  -- French Toast is categorized as Breakfast
    (8, 2),  -- Chicken Stir-Fry is categorized as Lunch
    (9, 3),  -- Vegetable Curry is categorized as Dinner
    (10, 3),  -- Beef Stroganoff is categorized as Dinner
    (11, 3);  -- Lemon Garlic Shrimp is categorized as Dinner






INSERT INTO Ingredients (name, amount, recipe_id)
VALUES
    ('Chocolate', 8, 12),
    ('Butter', 4, 12),
    ('Eggs', 2, 12),
    ('Sugar', 4, 12),
    ('Flour', 2, 12),
    ('Bell Peppers', 4, 13),
    ('Quinoa', 1, 13),
    ('Black Beans', 1, 13),
    ('Corn', 1, 13),
    ('Tofu', 1, 14),
    ('Water Chestnuts', 0.5, 14),
    ('Lettuce Leaves', 6, 14),
    ('Mangoes', 2, 15),
    ('Avocados', 2, 15),
    ('Red Onion', 0.5, 15),
    ('Cilantro', 0.25, 15),
    ('Lime Juice', 2, 15),
    ('Greek Yogurt', 1, 16),
    ('Fresh Berries', 1, 16),
    ('Granola', 0.5, 16),
    ('Honey', 2, 16);


-- Adding cooking steps for the new recipes
INSERT INTO cooking_steps (step, recipe_id)
VALUES
    ('Preheat the oven to 375°F', 12),
    ('Grease the ramekins with butter and dust with cocoa powder', 12),
    ('Melt the chocolate and butter together', 12),
    ('Whisk the eggs and sugar until light and fluffy', 12),
    ('Fold in the melted chocolate mixture and then the flour', 12),
    ('Pour the batter into the prepared ramekins and bake for 12-14 minutes', 12),
    ('Cut the tops off the bell peppers and remove the seeds and membranes', 13),
    ('Cook the quinoa according to package instructions', 13),
    ('Mix the cooked quinoa with black beans, corn, and spices', 13),
    ('Stuff the bell peppers with the quinoa mixture', 13),
    ('Crumble the tofu and stir-fry with water chestnuts and vegetables', 14),
    ('Wash and dry the lettuce leaves', 14),
    ('Spoon the tofu mixture onto the lettuce leaves and serve', 14),
    ('Prepare the mangoes, avocados, red onion, and cilantro', 15),
    ('Combine all the ingredients in a bowl and toss with lime juice', 15),
    ('Layer Greek yogurt, berries, and granola in a glass, drizzle with honey', 16);

-- Associating the new recipes with categories
INSERT INTO recipe_category(recipe_id, category_id)
VALUES
    (12, 3),  -- Chocolate Lava Cake is categorized as Dinner
    (13, 3),  -- Quinoa Stuffed Bell Peppers is categorized as Dinner
    (14, 2),  -- Tofu Lettuce Wraps is categorized as Lunch
    (15, 1),  -- Mango Avocado Salsa is categorized as Appetizers
    (16, 2);  -- Greek Yogurt Parfait is categorized as Lunch

