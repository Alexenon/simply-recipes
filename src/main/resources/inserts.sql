USE recipebookdb;

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
    (6, 'Chicken Alfredo', 'Creamy pasta dish with grilled chicken and Parmesan cheese', 'chicken-alfredo.jpg', 20, 30, CURDATE()),
    (7, 'French Toast', 'Classic breakfast dish made with bread soaked in eggs and milk, then fried', 'french-toast.jpg', 10, 15, CURDATE()),
    (8, 'Chicken Stir-Fry', 'Quick and flavorful stir-fry with chicken, vegetables, and a savory sauce', 'chicken-stir-fry.jpg', 15, 20, CURDATE()),
    (9, 'Vegetable Curry', 'Hearty and aromatic curry with a variety of vegetables and spices', 'vegetable-curry.jpg', 20, 30, CURDATE()),
    (10, 'Beef Stroganoff', 'Comforting beef dish cooked with onions, mushrooms, and sour cream, served over noodles', 'beef-stroganoff.jpg', 20, 25, CURDATE()),
    (11, 'Lemon Garlic Shrimp', 'Tender shrimp cooked in a zesty lemon and garlic sauce, perfect for a quick and light dinner', 'lemon-garlic-shrimp.jpg', 10, 15, CURDATE()),
    (12, 'Chocolate Lava Cake', 'Indulgent chocolate cake with a gooey, molten center, perfect for chocolate lovers', 'chocolate-lava-cake.jpg', 15, 20, CURDATE()),
    (13, 'Classic Cheesecake', 'Rich and creamy cheesecake with a buttery graham cracker crust, a timeless dessert favorite', 'classic-cheesecake.jpg', 30, 60, CURDATE()),
    (14, 'Blueberry Pancakes', 'Fluffy pancakes filled with juicy blueberries, a delightful breakfast treat', 'blueberry-pancakes.jpg', 15, 20, CURDATE()),
    (15, 'Avocado Toast', 'A simple and healthy breakfast option featuring creamy avocado on toasted bread', 'avocado-toast.jpg', 10, 10, CURDATE());


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
    ('Black pepper', 3, 2),
    ('Salmon fillets', 4, 3),
    ('Lemon', 1, 3),
    ('Fresh herbs', 2, 3),
    ('Beef sirloin', 500, 4),
    ('Taco seasoning', 2, 4),
    ('Tomatoes, diced', 2, 4),
    ('Onion, chopped', 1, 4),
    ('Lettuce, shredded', 1, 4),
    ('Tortillas', 8, 4),
    ('Mushrooms, sliced', 300, 5),
    ('Arborio rice', 1, 5),
    ('Vegetable broth', 4, 5),
    ('White wine', 1, 5),
    ('Onion, finely chopped', 1, 5),
    ('Garlic, minced', 3, 5),
    ('Parmesan cheese', 2, 5),
    ('Chicken breast', 2, 6),
    ('Heavy cream', 1, 6),
    ('Butter', 2, 6),
    ('Garlic, minced', 3, 6),
    ('Parmesan cheese', 1, 6),
    ('Bread slices', 4, 7),
    ('Eggs', 3, 7),
    ('Milk', 0.5, 7),
    ('Chicken breast, sliced', 500, 8),
    ('Bell peppers, sliced', 2, 8),
    ('Broccoli florets', 1, 8),
    ('Soy sauce', 2, 8),
    ('Vegetable oil', 2, 8),
    ('Carrots', 2, 9),
    ('Potatoes', 4, 9),
    ('Peas', 150, 9),
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
    ('Butter', 3, 11),
    ('Chocolate', 8, 12),
    ('Butter', 4, 12),
    ('Eggs', 2, 12),
    ('Sugar', 1.5, 12),
    ('Flour', 1, 12),
    ('Vanilla extract', 1, 12),
    ('Cocoa powder', 2, 12),
    ('Cream cheese', 16, 13),
    ('Sugar', 1.5, 13),
    ('Sour cream', 1, 13),
    ('Eggs', 3, 13),
    ('Vanilla extract', 1, 13),
    ('Graham cracker crumbs', 1.5, 13),
    ('Blueberries', 1, 14),
    ('Pancake mix', 1, 14),
    ('Milk', 1, 14),
    ('Eggs', 2, 14),
    ('Avocado', 1, 15),
    ('Bread slices', 2, 15),
    ('Lemon juice', 1, 15),
    ('Salt', 1, 15);

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
    ('Stir in the lemon juice and cook for another minute', 11),
    ('Preheat the oven to 425°F', 12),
    ('Butter the ramekins and dust with cocoa powder', 12),
    ('Melt the chocolate and butter in a bowl over simmering water', 12),
    ('Whisk the eggs, sugar, and vanilla extract in a bowl', 12),
    ('Fold in the melted chocolate mixture and then the flour', 12),
    ('Pour the batter into the prepared ramekins and bake for 12 minutes', 12),
    ('Mix the cream cheese and sugar until smooth', 13),
    ('Add the sour cream, eggs, and vanilla extract, mix until combined', 13),
    ('Pour the mixture over the graham cracker crust and bake for 60 minutes', 13),
    ('Mix pancake mix, milk, and eggs in a bowl', 14),
    ('Gently fold in the blueberries', 14),
    ('Pour the batter onto a hot griddle and cook until golden brown on both sides', 14),
    ('Mash the avocado with lemon juice and salt', 15),
    ('Spread the mashed avocado on toasted bread slices', 15);

-- Associating the new recipes with categories
INSERT INTO recipe_category(recipe_id, category_id)
VALUES
    (1, 1),  -- Salad Caesar is categorized as Breakfast
    (1, 2),  -- Salad Caesar is categorized as Lunch
	(1, 4),  -- Salad Caesar is categorized as Appetizers
    (2, 3),  -- Pasta Carbonara is categorized as Dinner
    (3, 3),  -- Grilled Salmon is categorized as Dinner
    (4, 4),  -- Beef Tacos is categorized as Dinner
    (5, 3),  -- Mushroom Risotto is categorized as Dinner
    (5, 4),  -- Mushroom Risotto is categorized as Appetizers
    (5, 6),  -- Mushroom Risotto is categorized as Healthy
    (6, 3),  -- Chicken Alfredo is categorized as Dinner
    (7, 1),  -- French Toast is categorized as Breakfast
    (8, 2),  -- Chicken Stir-Fry is categorized as Lunch
    (9, 3),  -- Vegetable Curry is categorized as Dinner
    (9, 6),  -- Vegetable Curry is categorized as Healthy
    (10, 3),  -- Beef Stroganoff is categorized as Dinner
    (11, 3),  -- Lemon Garlic Shrimp is categorized as Dinner
    (11, 4),  -- Lemon Garlic Shrimp is categorized as Appetizers
    (12, 5), -- Chocolate Lava Cake is categorized as Desserts
    (13, 5), -- Classic Cheesecake is categorized as Desserts
    (14, 1), -- Blueberry Pancakes is categorized as Breakfast
    (15, 1); -- Avocado Toast is categorized as Breakfast
